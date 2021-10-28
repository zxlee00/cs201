import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Step1 {

    
    
    
    
    // Step 1 -- store filtered businesses
    public static List<Business> filterRestaurantsToArrayList(String fileLoc, JSONParser parser) {
    	
    	List<Business> businessList = new ArrayList<Business>();
    	
    	try {
            String fileContent = FileUtils.readFileToString(new File(fileLoc), "UTF-8");
            String data = "[" + fileContent + "]";
            JSONArray a = (JSONArray)parser.parse(data);

            for (Object o : a) {
            	
                JSONObject business = (JSONObject) o;
    
                String businessId = (String) business.get("business_id");
    
                String name = (String) business.get("name");
    
                String categories = (String) business.get("categories");
                
                if(Objects.isNull(categories) || !categories.contains("Restaurant")) continue;

                businessList.add(new Business(businessId, name, categories));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    	
    	return businessList;
    }
}
