package datastructure;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Result {
        private static final String RESTURL = "https://jsonmock.hackerrank.com/api/food_outlets";

        public static List<String> getRelevantFoodOutlets(String city, int maxCost)
        {
            int page = 1;
            List<String> cityList = new ArrayList<>();
            try {
                cityList = getCities(city, page ,maxCost);
            } catch (Exception e) {
                System.out.println("Exception "+e);
            }
            return cityList;
        }

        public static List<String> getCities(String city, int page, int votes) throws Exception {

            List<String> cityList = new ArrayList<>();
            String cityName = null;
            String response = getResponsePerPage(RESTURL,city, page);
            int length = response.length();
            int maxVotes = 0;
            String outletName = "";
            for(int i  =0; i< length; i++){
                int cityStart = response.indexOf("city:");
                int cityEnd = response.indexOf("name:");
                int votesStart = response.indexOf("votes:");
                int votesEnd = response.indexOf("},id:");
                maxVotes = Integer.parseInt(response.substring(votesStart,votesEnd));
                outletName = response.substring(cityStart,cityEnd);
                if(maxVotes > votes){
                    votes = maxVotes;
                    //outletName =
                }
            }

//            JsonObject jsonResponse = new Gson().fromJson(response, JsonObject.class);
//            int totalPages = jsonResponse.get("total_pages").getAsInt();
//            JsonArray data = jsonResponse.getAsJsonArray("data");
//
//            for (JsonElement e : data) {
//                if(e.getAsJsonObject().get("estimated_cost").getAsInt() < maxcost) {
//                    cityName = e.getAsJsonObject().get("name").getAsString();
//                    System.out.println("cityName "+cityName);
//                    cityList.add(cityName);
//                }
//
//            }
            //return totalPages==page? cityList : getCities(city, page+1, maxcost);
            //return page== page? cityList : getCities(city, page+1, maxcost);
            return  null;
        }

        public static String getResponsePerPage(String endpoint,String city, int page) throws MalformedURLException, IOException, ProtocolException {

            String newurl = endpoint+"?city="+city+"&page="+page;
            System.out.println("New Url "+newurl);
            URL url = new URL(newurl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.addRequestProperty("Content-Type", "application/json");

            int status = con.getResponseCode();
            if(status<200 || status>=300) {
                throw new IOException("Error in reading data with status:"+status);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String response;
            StringBuilder sb = new StringBuilder();
            while((response = br.readLine())!=null) {
                sb.append(response);
            }

            br.close();
            con.disconnect();

            return sb.toString();
        }
    }

    public class FoodOutlet {
        public static void main(String[] args) throws Exception {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//            String city = bufferedReader.readLine();
//
//            int maxCost = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> result = Result.getRelevantFoodOutlets("Seattle", 2);

//            for (int i = 0; i < result.size(); i++) {
//                bufferedWriter.write(result.get(i));
//
//                if (i != result.size() - 1) {
//                    bufferedWriter.write("\n");
//                }
//            }
//
//            bufferedWriter.newLine();
//
//            bufferedReader.close();
//            bufferedWriter.close();
        }
}
