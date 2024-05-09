package com.sales;

public class SalesAnalyzer {
	
	
	private double[] sales;
    private int noSales;
    
    
    
    public SalesAnalyzer(int Sales) {
       this. sales = new double[Sales];
        this.noSales = 0;
    }

    public void addSale(double saleAmount) {
        try {
            if (noSales < sales.length) {
                if (saleAmount < 0) {
                    throw new IllegalArgumentException("Sale amount cannot be negative.");
                }
                sales[noSales] = saleAmount;
                noSales++;
            } else {
                throw new IllegalStateException("Cannot add sale. Sales array is full.");
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public double calculateTotalSales() {
        double totalSales = 0;
        for (int i = 0; i < noSales; i++) {
            totalSales += sales[i];
        }
        return totalSales;
    }

    public double calculateAverageDailySales() {
        if (noSales == 0) {
            System.out.println("No sales recorded.");
            return 0;
        }
        return calculateTotalSales() / noSales;
    }

    public int findBestSalesDay() {
        if (noSales == 0) {
            System.out.println("No sales recorded.");
            return -1;
        }
        int bestDay = 0;
        for (int i = 1; i < noSales; i++) {
            if (sales[i] > sales[bestDay]) {
                bestDay = i;
            }
        }
        return bestDay + 1; 
    }

    public int findWorstSalesDay() {
        if (noSales == 0) {
            System.out.println("No sales recorded.");
            return -1;
        }
        int worstDay = 0;
        for (int i = 1; i < noSales; i++) {
            if (sales[i] < sales[worstDay]) {
                worstDay = i;
            }
        }
        return worstDay + 1; 
    }

    public void displaySalesReport() {
        double totalSales = calculateTotalSales();
        double averageDailySales = calculateAverageDailySales();
        int bestDay = findBestSalesDay();
        int worstDay = findWorstSalesDay();

        System.out.println("Total Sales: " + totalSales);
        System.out.println("Average Daily Sales: " + averageDailySales);
        if (bestDay != -1) {
            System.out.println("Best Sales Day: Day " + bestDay);
        }
        if (worstDay != -1) {
            System.out.println("Worst Sales Day: Day " + worstDay);
        }
    }
    
    
    public static void main(String[] args) {
        SalesAnalyzer analyzer = new SalesAnalyzer(31); 
        analyzer.addSale(1000);
        analyzer.addSale(1500);
        analyzer.addSale(-200); 
        analyzer.addSale(500);
        analyzer.addSale(1200);

        analyzer.displaySalesReport();
    }

}
