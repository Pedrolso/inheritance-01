package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class program {
    public static void main(String[] args) throws ParseException {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int prdNumber = sc.nextInt();

        for (int i = 1; i <= prdNumber; i++) {
            System.out.println("Product #" + i + " data:");

            System.out.print("Common, Used or Imported: ");
            char cui = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String prodName = sc.nextLine();

            System.out.print("Price: ");
            Double prodPrice = sc.nextDouble();

            if (cui == 'c') {
                Product product = new Product(prodName, prodPrice);
                list.add(product);
            } else if (cui == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                sc.nextLine();
                Date manufacture = sdf.parse(sc.nextLine());

                Product uProduct = new UsedProduct(prodName, prodPrice, manufacture);
                list.add(uProduct);
            } else if (cui == 'i') {
                System.out.print("Customs fee: ");
                Double custom = sc.nextDouble();

                Product iproduct = new ImportedProduct(prodName, prodPrice, custom);
                list.add(iproduct);
            }

        }
        System.out.println();
        System.out.println("PRICE TAGS: ");

        for (Product c : list) {
            System.out.println(c.priceTag());
        }
    }
}
