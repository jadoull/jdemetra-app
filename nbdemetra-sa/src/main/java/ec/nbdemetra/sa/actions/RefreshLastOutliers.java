/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.nbdemetra.sa.actions;

import ec.nbdemetra.sa.MultiProcessingManager;
import ec.nbdemetra.sa.SaBatchUI;
import ec.nbdemetra.ui.ActiveViewManager;
import ec.tss.sa.EstimationPolicyType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(category = "SaProcessing",
id = "ec.nbdemetra.sa.RefreshLastOutliers")
@ActionRegistration(displayName = "#CTL_RefreshLastOutliers")
@ActionReferences({
    @ActionReference(path = MultiProcessingManager.CONTEXTPATH+RefreshPartial.PATH, position = 1240)
})
@Messages("CTL_RefreshLastOutliers=Last outliers")
public final class RefreshLastOutliers implements ActionListener {

     public RefreshLastOutliers() {
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        SaBatchUI ui = ActiveViewManager.getInstance().getLookup().lookup(SaBatchUI.class);
        if (ui == null) {
            return;
        }
        ui.refresh(EstimationPolicyType.LastOutliers, false, true);
    }
}
