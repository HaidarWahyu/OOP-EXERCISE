public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomer("Haidar", "Rahman");
        bank.addCustomer("Budi", "Santoso");
        bank.addCustomer("Siti", "Aminah");

        bank.getCustomer(0).setAccount(new Account(100000));
        bank.getCustomer(0).setAccount(new Account(500000));
        bank.getCustomer(1).setAccount(new Account(250000));
        bank.getCustomer(2).setAccount(new Account(0));

        System.out.println("Welcome TO the Bank");
        System.out.println("Jumlah nasabah: " + bank.getNumOfCustomers());
        System.out.println();

        Customer c = bank.getCustomer(0);
        Account acc = c.getAccount(0);

        System.out.println("Nasabah             : " + c.getFirstName() + " " + c.getLastName());
        System.out.println("Current Balance     : " + acc.getBalance());
        System.out.println();

        bank.doDeposit(acc, 50000);
        bank.doWithdraw(acc, 150000);
        bank.doWithdraw(acc, 1);

        bank.printCustomers();
    }
}
