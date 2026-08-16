class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> arrived = new HashMap<>();

        for(List<String> iternary: tickets){
            String start = iternary.get(0);
            String end = iternary.get(1);

            arrived
            .computeIfAbsent(start, k -> new PriorityQueue())
            .add(end);
        }

        LinkedList<String> result = new LinkedList();

        bfs("JFK",arrived,result);

        return result;
    }

    void bfs(String start, Map<String,PriorityQueue<String>> arrived, 
    LinkedList<String> result){

        PriorityQueue<String> arrival = arrived.get(start);

        while(arrival!=null && !arrival.isEmpty()){
            bfs(arrival.poll(),arrived,result);
        }

        result.addFirst(start);
    }
}