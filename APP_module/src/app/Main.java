package app;
/*Importing others Modules */
import businessreg.BusinessService;
import passport.PassportProvider;
import api.NationalIDService;
import api.NationalIdProvider;
import tax_api.TaxProvider;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        NationalIDService Service = NationalIdProvider.get();

        System.out.println("===== SYSTEM FEATURES =====");
        System.out.println("1 : National ID, registered citizens:\n" + Service.GetCitycenNumber());
        System.out.println("2 : Tax, tax on 1000000 = " + TaxProvider.get().calculateTax(1000000));
        System.out.println("3 : Passport, " + new PassportProvider().apply("CM18749"));
        System.out.println("4 : Business, " + new BusinessService().register("Kampala Traders", "CM17623"));


        JOptionPane.showMessageDialog(null, "====WELCOME TO UGANDA NATIONAL SERVICE===== \n " +
                "1 : for registering the national ID \n " +
                "2 : for taxing people \n " +
                "3 : for applying for the passport \n " +
                "4 : for registering for a business");
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
            } else if (cs.equals("3")) {
                JOptionPane.showMessageDialog(null, "============ WELCOME TO THE PASSPORT SERVICE=============");
                String passportName = JOptionPane.showInputDialog("Enter the NIN of the applicant !");
                JOptionPane.showMessageDialog(null, new PassportProvider().apply(passportName));
                cs = JOptionPane.showInputDialog("Enter the service number");
            } else if (cs.equals("4")) {
                JOptionPane.showMessageDialog(null, "WELCOME TO THE BUSINESS SERVICE=============");
                String businessName = JOptionPane.showInputDialog("Enter the business name !");
                String NINname = JOptionPane.showInputDialog("Enter the owner NIN!");
                JOptionPane.showMessageDialog(null, new BusinessService().register(businessName, NINname));
                cs = JOptionPane.showInputDialog("Enter the service number");
            } else {
                JOptionPane.showMessageDialog(null, "Service invalid");
                cs = JOptionPane.showInputDialog("Enter the service number");
            }
        }



    }
}
