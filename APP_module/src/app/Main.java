package app;

import api.NationalIDService;
import api.NationalIdProvider;
import tax_api.TaxProvider;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        NationalIDService Service = NationalIdProvider.get();

        JOptionPane.showMessageDialog(null, "====WELCOME TO UGANDA NATIONAL SERVICE===== \n " +
                "1 : for registering the national ID \n " +
                "2 : for taxing people");
        String cs = JOptionPane.showInputDialog("Enter the service number");
        while (true) {
            if (cs.equals("1")) {
                JOptionPane.showMessageDialog(null, "Welcome to the NATIONAL ID SERVICE\n" +
                        "1 : For registering the national ID \n " +
                        "2 : For seeing all the people registered ");
                String ns = JOptionPane.showInputDialog("Enter the service number");
                if (ns.equals("1")) {
                    String nin = JOptionPane.showInputDialog("Enter Nin:");
                    if (nin == null) return;
                    String name = JOptionPane.showInputDialog("Enter Name:");
                    if (name == null) return;
                    Service.SetNewcitycen(nin, name);
                    cs = JOptionPane.showInputDialog("Enter the service number");
                } else if (ns.equals("2")) {
                    JOptionPane.showMessageDialog(null, "This all the cityzen registered !\n\n" + Service.GetCitycenNumber());
                    cs = JOptionPane.showInputDialog("Enter the service number");
                }
            } else if (cs.equals("2")) {
                JOptionPane.showMessageDialog(null, "========== WELCOME TO THE TAXING SERVICE=============");
                double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount:"));
                double tp = TaxProvider.get().calculateTax(amount);
                JOptionPane.showMessageDialog(null, "Tax on " + amount + "\n" + "Here's the tax " + tp);
                cs = JOptionPane.showInputDialog("Enter the service number");
            } else {
                JOptionPane.showMessageDialog(null, "Service invalid");
                cs = JOptionPane.showInputDialog("Enter the service number");
            }
        }

    }
}
