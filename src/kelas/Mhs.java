
package kelas;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.*;
/**
 *
 * @author MyBook Hype
 */

public class Mhs {
    String token = "ufb2a73ed1e2bae2403ea3b3e9b5eb86ed6fdb66b49";
    String query ;
    private static JSONArray dataMhs;
    private static int baris;


    public static JSONArray getDataMhs() {
        return dataMhs;
    }

    public static void setDataMhs(JSONArray dataMhs) {
        Mhs.dataMhs = dataMhs;
    }

    public static int getBaris() {
        return baris;
    }

    public static void setBaris(int baris) {
        Mhs.baris = baris;
    }
 public JSONObject getMahasiswa(){
        query = "select * from t_mhs where angkatan = 2023 and deleted = 0 limit 200";
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=t466f5cfki1nfdke45cn8qp8d4")
                .body("{\"token\":\""+ token +"\",\r\n\"query\":\""+ query +"\"}")
                .asString();
        
        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        
        return obj;
    }
  
     
        
    }