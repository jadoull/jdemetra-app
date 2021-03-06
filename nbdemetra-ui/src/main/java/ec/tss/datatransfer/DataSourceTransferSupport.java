/*
 * Copyright 2013 National Bank of Belgium
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved 
 * by the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * http://ec.europa.eu/idabc/eupl
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and 
 * limitations under the Licence.
 */
package ec.tss.datatransfer;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import ec.nbdemetra.core.GlobalService;
import ec.tss.tsproviders.DataSource;
import java.awt.datatransfer.Transferable;
import javax.annotation.Nonnull;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;

/**
 * A support class that deals with DataSource in Transferable.
 *
 * @author Philippe Charles
 */
@GlobalService
@ServiceProvider(service = DataSourceTransferSupport.class)
public class DataSourceTransferSupport {

    @Nonnull
    public static DataSourceTransferSupport getDefault() {
        return Lookup.getDefault().lookup(DataSourceTransferSupport.class);
    }

    @Deprecated
    @Nonnull
    public static DataSourceTransferSupport getInstance() {
        return getDefault();
    }

    @Nonnull
    public FluentIterable<? extends DataSourceTransferHandler> all() {
        return FluentIterable.from(Lookup.getDefault().lookupAll(DataSourceTransferHandler.class));
    }

    public boolean canHandle(@Nonnull Transferable t) {
        return all().anyMatch(canHandlePredicate(t));
    }

    public boolean canHandle(@Nonnull Transferable t, @Nonnull String providerName) {
        return all().anyMatch(canHandlePredicate(t, providerName));
    }

    @Nonnull
    public Optional<DataSource> getDataSource(@Nonnull Transferable t) {
        for (DataSourceTransferHandler o : all().filter(canHandlePredicate(t))) {
            Optional<DataSource> dataSource = o.getDataSource(t);
            if (dataSource.isPresent()) {
                return dataSource;
            }
        }
        return Optional.absent();
    }

    @Nonnull
    public Optional<DataSource> getDataSource(@Nonnull Transferable t, @Nonnull String providerName) {
        for (DataSourceTransferHandler o : all().filter(canHandlePredicate(t, providerName))) {
            Optional<DataSource> dataSource = o.getDataSource(t, providerName);
            if (dataSource.isPresent()) {
                return dataSource;
            }
        }
        return Optional.absent();
    }

    private static Predicate<DataSourceTransferHandler> canHandlePredicate(final Transferable t) {
        return new Predicate<DataSourceTransferHandler>() {
            @Override
            public boolean apply(DataSourceTransferHandler input) {
                return input != null ? input.canHandle(t) : false;
            }
        };
    }

    private static Predicate<DataSourceTransferHandler> canHandlePredicate(final Transferable t, final String providerName) {
        return new Predicate<DataSourceTransferHandler>() {
            @Override
            public boolean apply(DataSourceTransferHandler input) {
                return input != null ? input.canHandle(t, providerName) : false;
            }
        };
    }
}
