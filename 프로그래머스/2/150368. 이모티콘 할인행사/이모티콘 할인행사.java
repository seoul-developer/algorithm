import java.util.*;

class Solution {
    
    static List<Integer> vals = new ArrayList<>(List.of(10,20,30,40));
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] sales = new int[emoticons.length];
        
        Queue<Bfs> queue = new LinkedList<>();
        queue.offer(new Bfs(sales, 0));
        
        List<Result> result = new ArrayList<>();
        
        while(!queue.isEmpty()){
            Bfs curr = queue.poll();
            int[] currSales = curr.sales;
            int currIdx = curr.idx;
                        
            // find next
            if(currIdx == emoticons.length){
                // calculate
                // System.out.printf("sales: %s%n", Arrays.toString(currSales));
                Result res = calculate(currSales, users, emoticons);
                result.add(res);
                continue;
            }
            
            for(int val: vals) {                
                int[] nextSales = Arrays.copyOf(currSales, currSales.length);
                nextSales[currIdx] = val;
                queue.offer(new Bfs(nextSales, currIdx+1));
            }
        }
        
        Collections.sort(result, (a,b) -> {
            if(a.num != b.num) {
                return b.num - a.num;
            }
            return b.price - a.price;
        });
        
        Result ans = result.get(0);
        return new int[]{ans.num, ans.price};
    }
    
    private Result calculate(int[] sales, int[][] users, int[] emoticons) {
        int num = 0;
        int priceTotal = 0;
        
        loop: for(int[] user: users) {
            int total = 0;
            
            int minPercent = user[0];
            int maxPrice = user[1];
            
            for(int i=0; i<emoticons.length; i++) {
                int emoPrice = emoticons[i];
                int salePer = sales[i];
                
                if(salePer >= minPercent) {
                    int salePrice = emoPrice * (100 - salePer) / 100;
                    total += salePrice;
                    // System.out.printf("ind: %d, 정가: %d, salePer: %d, salePrice: %d, total: %d, minper: %d, minPrice: %d%n", i, emoPrice, salePer, salePrice, total, minPercent, maxPrice);

                    if(total >= maxPrice) {
                        num++;
                        continue loop;
                    }
                }
            }
            priceTotal += total;
        }
        
        return new Result(num, priceTotal);
    }
}

class Bfs {
    int[] sales; 
    int idx;
    
    public Bfs(int[] sales, int idx) {
        this.sales = sales;
        this.idx = idx;
    }
}

class Result {
    int num;
    int price;
    
    public Result(int a, int b){
        this.num=a;
        this.price=b;
    }
}