/*
 * Copyright 2013 National Bank of Belgium
 * 
 * Licensed under the EUPL, Version 1.1 or - as soon they will be approved 
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
package ec.nbdemetra.ui;

import ec.nbdemetra.core.GlobalService;
import ec.nbdemetra.ui.tsproviders.DataSourceProviderBuddySupport;
import ec.tss.Ts;
import ec.tss.TsMoniker;
import ec.tss.tsproviders.DataSet;
import ec.tss.tsproviders.DataSource;
import java.awt.Image;
import java.beans.BeanInfo;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.Icon;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;

/**
 * TODO: improve this API
 *
 * @author Philippe Charles
 */
@GlobalService
@ServiceProvider(service = MonikerUI.class)
public class MonikerUI {

    @Nonnull
    public static MonikerUI getDefault() {
        return Lookup.getDefault().lookup(MonikerUI.class);
    }

    @Nullable
    public Icon getIcon(@Nonnull TsMoniker moniker) {
        Image result = DataSourceProviderBuddySupport.getDefault().get(moniker).getIcon(moniker, BeanInfo.ICON_COLOR_16x16, false);
        return result != null ? ImageUtilities.image2Icon(result) : null;
    }

    @Deprecated
    public Icon getIcon(DataSet dataSet) {
        return getIcon(dataSet.getDataSource());
    }

    @Deprecated
    public Icon getIcon(DataSource dataSource) {
        Image result = DataSourceProviderBuddySupport.getDefault().get(dataSource.getProviderName()).getIcon(BeanInfo.ICON_COLOR_16x16, false);
        return result != null ? ImageUtilities.image2Icon(result) : null;
    }

    @Deprecated
    public Image getImage(Ts ts) {
        return DataSourceProviderBuddySupport.getDefault().get(ts.getMoniker()).getIcon(BeanInfo.ICON_COLOR_16x16, false);
    }

    @Deprecated
    public Icon getIcon(Ts ts) {
        Image result = DataSourceProviderBuddySupport.getDefault().get(ts.getMoniker()).getIcon(BeanInfo.ICON_COLOR_16x16, false);
        return result != null ? ImageUtilities.image2Icon(result) : null;
    }
}
