package Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import classes.Customer;
import classes.Order;
import classes.Product;

public class MainProject {

	public static void main(String[] args) {
		
		List<Product> productList = new ArrayList<>();
		List<Order> orderList = new ArrayList<>();
		
        Product prod1 = new Product(1, "The Lord of the rings", "books", 120.0);
        Product prod2 = new Product(2, "A song of ice and fire", "books", 90.0);
        Product prod3 = new Product(3, "Eragon", "books", 150.0);
        Product prod4 = new Product(4, "T shirt blu", "boys", 50.0);
        Product prod5 = new Product(5, "IPhone 20", "electronics", 500.0);
        Product prod6 = new Product(6, "Lego set", "toys", 30.0);
        Product prod7 = new Product(7, "Libro", "books", 120.0);
        Product prod8 = new Product(8, "Colori", "baby", 15.0);
        Product prod9 = new Product(9, "Trenino", "toys", 25.0);
        Product prod10 = new Product(10, "Cosa per bambini", "baby", 10.0);
        Product prod11 = new Product(11, "Scarpe", "boys", 50.0);
        
        Order order1 = new Order(1, "Pending", LocalDate.now(), LocalDate.now().plusDays(3),
                List.of(prod1, prod2), new Customer(1, "John Doe", 1));
        Order order2 = new Order(2, "Delivered", LocalDate.now().minusDays(5), LocalDate.now().minusDays(2),
                List.of(prod3), new Customer(2, "Jane Smith", 2));
        Order order3 = new Order(3, "Pending", LocalDate.now().minusDays(2), LocalDate.now().plusDays(1),
                List.of(prod2, prod8), new Customer(3, "Michael Johnson", 1));
        Order order4 = new Order(4, "Delivered", LocalDate.now().minusDays(7), LocalDate.now().minusDays(3),
                List.of(prod10), new Customer(4, "Emily Davis", 3));
        Order order5 = new Order(5, "Delivered", LocalDate.of(2021, 2, 3), LocalDate.now().minusDays(3),
                List.of(prod7), new Customer(4, "Davide Aprea", 2));
        Order order6 = new Order(6, "Delivered", LocalDate.of(2021, 3, 15), LocalDate.now().minusDays(3),
                List.of(prod4), new Customer(4, "Vincenzo Salzano", 2));
        
        productList.add(prod1);
        productList.add(prod2);
        productList.add(prod3);
        productList.add(prod4);
        productList.add(prod5);
        productList.add(prod6);
        productList.add(prod7);
        productList.add(prod8);
        productList.add(prod9);
        productList.add(prod10);
        productList.add(prod11);

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);
        orderList.add(order6);
        // Es. 1
        
        List<Product> filteredProducts = productList.stream()
                .filter(p -> p.getCategory().equals("books"))
                .filter(p -> p.getPrice() > 100)
                .collect(Collectors.toList());
        
        for (Product product : filteredProducts) {
            System.out.println(product.getName());
        }
        
        // Es. 2
        
        List<Order> filteredOrders = orderList.stream()
                .filter(order -> order.getProducts().stream().anyMatch(p -> p.getCategory().equals("baby")))
                .collect(Collectors.toList());
        
        for (Order order : filteredOrders) {
        	System.out.println(order.getId());
        }
        
        // Es. 3
        
        List<Product> onSaleProducts = productList.stream()
                .filter(p -> p.getCategory().equals("boys"))
                .map(p -> {
                    p.setPrice(p.getPrice() * 0.9);
                    return p;
                })
                .collect(Collectors.toList());
        
        for (Product product : onSaleProducts) {
        	System.out.println(product.getName() + " prezzo scontato:" + product.getPrice());
        }
        
        // Es. 4
        
        List<Order> filteredByDate = orderList.stream()
        		.filter(o -> o.getCustomer().getTier() == 2 
        		&& o.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)) 
        		&& o.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
        		.collect(Collectors.toList());
        
        List<Product>tier2Prod = new ArrayList();
        					
        for (Order order : filteredByDate) {
          	order.getProducts().forEach(p -> tier2Prod.add(p));
        }
        
        for (int i = 0; i < tier2Prod.size(); i++) {
            Product value = tier2Prod.get(i);
            System.out.println(value.getName());
        }
        

	}

}
