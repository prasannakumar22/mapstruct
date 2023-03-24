package com.example.mapstruct.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapstruct.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.jsonpointer.JsonPointerException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.ReadContext;

@RestController
public class JsonPatchTestController {
	
	@Value("#{${pathsmap}}")
	private Map<String,List<String>> mp;

	@GetMapping("/jsonPatch")
	public void testJsonPatch() throws JsonMappingException, JsonProcessingException, IOException, JsonPatchException {
		String json="{\"name\":\"prasanna\"}";
		String patch =" [{ \"op\": \"add\", \"path\": \"/phoneNumber\", \"value\": \"+01-123-456-7890\"}]";
		ObjectMapper mapper = new ObjectMapper();
		
		JsonPatch jsonPatch = JsonPatch.fromJson(mapper.readTree(patch)) ;
		JsonNode node =jsonPatch.apply(mapper.readTree(json));
		System.out.println(mapper.writeValueAsString(node));
	}
	
	@GetMapping("/testjsonPatch")
	public void testJsonPatch2() throws Exception {
		//String json="{\"header\":{\"submissionDateTime\":{\"value\":\"2023-03-17T19:15:59Z\",\"timezone\":\"UTC\"},\"source\":\"PID\",\"traceId\":\"44ea5cb9-7aab-4590-856a-2ebda3bdcfc0\",\"transactionType\":\"ADD\"},\"products\":[{\"gtin14\":\"00031259008936\",\"productDescription\":[{\"value\":\"YLWTAIL-WDBRDG PLLT SHPR\",\"lang\":\"EN-US\"}],\"productType\":\"EA\",\"legacyData\":[{\"legacySystemId\":\"PID\",\"legacyEntityId\":\"NONE\",\"legacyAttributeName\":\"UPCTYPE\",\"legacyAttributeValue\":\"CONS\"}]},{\"gtin14\":\"00031259008950\",\"productDescription\":[{\"value\":\"YLWTAIL-WDBRDG PLLT SHPR\",\"lang\":\"EN-US\"}],\"productType\":\"EA\",\"legacyData\":[{\"legacySystemId\":\"PID\",\"legacyEntityId\":\"NONE\",\"legacyAttributeName\":\"UPCTYPE\",\"legacyAttributeValue\":\"CONS\"}]},{\"gtin14\":\"00031259009230\",\"productDescription\":[{\"value\":\"YLWTAIL-WDBRDG PLLT SHPR\",\"lang\":\"EN-US\"}],\"productType\":\"EA\",\"legacyData\":[{\"legacySystemId\":\"PID\",\"legacyEntityId\":\"NONE\",\"legacyAttributeName\":\"UPCTYPE\",\"legacyAttributeValue\":\"CONS\"}]},{\"gtin14\":\"00031259009469\",\"productDescription\":[{\"value\":\"YLWTAIL-WDBRDG PLLT SHPR\",\"lang\":\"EN-US\"}],\"productType\":\"EA\",\"legacyData\":[{\"legacySystemId\":\"PID\",\"legacyEntityId\":\"NONE\",\"legacyAttributeName\":\"UPCTYPE\",\"legacyAttributeValue\":\"CONS\"}]},{\"gtin14\":\"00031259999999\",\"productDescription\":[{\"value\":\"YLWTAIL-WDBRDG PLLT SHPR\",\"lang\":\"EN-US\"}],\"productType\":\"PK\",\"legacyData\":[{\"legacySystemId\":\"PID\",\"legacyEntityId\":\"NONE\",\"legacyAttributeName\":\"UPCTYPE\",\"legacyAttributeValue\":\"CONS\"}]},{\"gtin14\":\"00086003000506\",\"productDescription\":[{\"value\":\"YLWTAIL-WDBRDG PLLT SHPR\",\"lang\":\"EN-US\"}],\"productType\":\"EA\",\"legacyData\":[{\"legacySystemId\":\"PID\",\"legacyEntityId\":\"NONE\",\"legacyAttributeName\":\"UPCTYPE\",\"legacyAttributeValue\":\"CONS\"}]},{\"gtin14\":\"00086003813854\",\"productDescription\":[{\"value\":\"YLWTAIL-WDBRDG PLLT SHPR\",\"lang\":\"EN-US\"}],\"productType\":\"EA\",\"legacyData\":[{\"legacySystemId\":\"PID\",\"legacyEntityId\":\"NONE\",\"legacyAttributeName\":\"UPCTYPE\",\"legacyAttributeValue\":\"CONS\"}]},{\"gtin14\":\"00086003863866\",\"productDescription\":[{\"value\":\"YLWTAIL-WDBRDG PLLT SHPR\",\"lang\":\"EN-US\"}],\"productType\":\"EA\",\"legacyData\":[{\"legacySystemId\":\"PID\",\"legacyEntityId\":\"NONE\",\"legacyAttributeName\":\"UPCTYPE\",\"legacyAttributeValue\":\"CONS\"}]},{\"gtin14\":\"00086003873889\",\"productDescription\":[{\"value\":\"YLWTAIL-WDBRDG PLLT SHPR\",\"lang\":\"EN-US\"}],\"productType\":\"EA\",\"legacyData\":[{\"legacySystemId\":\"PID\",\"legacyEntityId\":\"NONE\",\"legacyAttributeName\":\"UPCTYPE\",\"legacyAttributeValue\":\"CONS\"}]},{\"gtin14\":\"00839743001582\",\"productDescription\":[{\"value\":\"YLWTAIL-WDBRDG PLLT SHPR\",\"lang\":\"EN-US\"}],\"productType\":\"EA\",\"legacyData\":[{\"legacySystemId\":\"PID\",\"legacyEntityId\":\"NONE\",\"legacyAttributeName\":\"UPCTYPE\",\"legacyAttributeValue\":\"CONS\"}]},{\"gtin14\":\"10031259999996\",\"productDescription\":[{\"value\":\"YLWTAIL-WDBRDG PLLT SHPR\",\"lang\":\"EN-US\"}],\"productType\":\"CA\",\"legacyData\":[{\"legacySystemId\":\"PID\",\"legacyEntityId\":\"NONE\",\"legacyAttributeName\":\"UPCTYPE\",\"legacyAttributeValue\":\"CASE\"},{\"legacySystemId\":\"PID\",\"legacyEntityId\":\"PIDPDTCA\",\"legacyAttributeName\":\"CAS_DSC_TX\",\"legacyAttributeValue\":\"YLWTAIL-WDBRDG PLLT SHPR\"}]}],\"packageHierarchy\":{\"parentItem\":[{\"gtin\":\"10031259999996\",\"numberOfUniqueGtins\":\"10\",\"childItem\":[{\"gtin\":\"00031259008936\",\"quantity\":48},{\"gtin\":\"00031259008950\",\"quantity\":36},{\"gtin\":\"00031259009230\",\"quantity\":30},{\"gtin\":\"00031259009469\",\"quantity\":24},{\"gtin\":\"00031259999999\",\"quantity\":1},{\"gtin\":\"00086003000506\",\"quantity\":12},{\"gtin\":\"00086003813854\",\"quantity\":30},{\"gtin\":\"00086003863866\",\"quantity\":18},{\"gtin\":\"00086003873889\",\"quantity\":14},{\"gtin\":\"00839743001582\",\"quantity\":6}]}]}}";
		String json ="{\r\n"
				+ "  \"header\": {\r\n"
				+ "    \"submissionDateTime\": {\r\n"
				+ "      \"value\": \"2023-03-17T19:15:59Z\",\r\n"
				+ "      \"timezone\": \"UTC\"\r\n"
				+ "    },\r\n"
				+ "    \"source\": \"PID\",\r\n"
				+ "    \"traceId\": \"44ea5cb9-7aab-4590-856a-2ebda3bdcfc0\",\r\n"
				+ "    \"transactionType\": \"ADD\"\r\n"
				+ "  },\r\n"
				+ "  \"products\": [\r\n"
				+ "    {\r\n"
				+ "      \"gtin14\": \"00031259008936\",\r\n"
				+ "      \"seller\":\"asdf\",\r\n"
				+ "      \"productDescription\": [\r\n"
				+ "        {\r\n"
				+ "          \"value\": \"YLWTAIL-WDBRDG PLLT SHPR\",\r\n"
				+ "          \"lang\": \"EN-US\"\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"productType\": \"EA\",\r\n"
				+ "      \"legacyData\": [\r\n"
				+ "        {\r\n"
				+ "          \"legacySystemId\": \"PID\",\r\n"
				+ "          \"legacyEntityId\": \"NONE\",\r\n"
				+ "          \"legacyAttributeName\": \"UPCTYPE\",\r\n"
				+ "          \"legacyAttributeValue\": \"CONS\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"gtin14\": \"00031259008950\",\r\n"
				+ "      \"productDescription\": [\r\n"
				+ "        {\r\n"
				+ "          \"value\": \"YLWTAIL-WDBRDG PLLT SHPR\",\r\n"
				+ "          \"lang\": \"EN-US\"\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"productType\": \"EA\",\r\n"
				+ "      \"legacyData\": [\r\n"
				+ "        {\r\n"
				+ "          \"legacySystemId\": \"PID\",\r\n"
				+ "          \"legacyEntityId\": \"NONE\",\r\n"
				+ "          \"legacyAttributeName\": \"UPCTYPE\",\r\n"
				+ "          \"legacyAttributeValue\": \"CONS\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"gtin14\": \"00031259009230\",\r\n"
				+ "      \"productDescription\": [\r\n"
				+ "        {\r\n"
				+ "          \"value\": \"YLWTAIL-WDBRDG PLLT SHPR\",\r\n"
				+ "          \"lang\": \"EN-US\"\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"productType\": \"EA\",\r\n"
				+ "      \"legacyData\": [\r\n"
				+ "        {\r\n"
				+ "          \"legacySystemId\": \"PID\",\r\n"
				+ "          \"legacyEntityId\": \"NONE\",\r\n"
				+ "          \"legacyAttributeName\": \"UPCTYPE\",\r\n"
				+ "          \"legacyAttributeValue\": \"CONS\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"gtin14\": \"00031259009469\",\r\n"
				+ "      \"productDescription\": [\r\n"
				+ "        {\r\n"
				+ "          \"value\": \"YLWTAIL-WDBRDG PLLT SHPR\",\r\n"
				+ "          \"lang\": \"EN-US\"\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"productType\": \"EA\",\r\n"
				+ "      \"legacyData\": [\r\n"
				+ "        {\r\n"
				+ "          \"legacySystemId\": \"PID\",\r\n"
				+ "          \"legacyEntityId\": \"NONE\",\r\n"
				+ "          \"legacyAttributeName\": \"UPCTYPE\",\r\n"
				+ "          \"legacyAttributeValue\": \"CONS\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"gtin14\": \"00031259999999\",\r\n"
				+ "      \"productDescription\": [\r\n"
				+ "        {\r\n"
				+ "          \"value\": \"YLWTAIL-WDBRDG PLLT SHPR\",\r\n"
				+ "          \"lang\": \"EN-US\"\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"productType\": \"PK\",\r\n"
				+ "      \"legacyData\": [\r\n"
				+ "        {\r\n"
				+ "          \"legacySystemId\": \"PID\",\r\n"
				+ "          \"legacyEntityId\": \"NONE\",\r\n"
				+ "          \"legacyAttributeName\": \"UPCTYPE\",\r\n"
				+ "          \"legacyAttributeValue\": \"CONS\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"gtin14\": \"00086003000506\",\r\n"
				+ "      \"productDescription\": [\r\n"
				+ "        {\r\n"
				+ "          \"value\": \"YLWTAIL-WDBRDG PLLT SHPR\",\r\n"
				+ "          \"lang\": \"EN-US\"\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"productType\": \"EA\",\r\n"
				+ "      \"legacyData\": [\r\n"
				+ "        {\r\n"
				+ "          \"legacySystemId\": \"PID\",\r\n"
				+ "          \"legacyEntityId\": \"NONE\",\r\n"
				+ "          \"legacyAttributeName\": \"UPCTYPE\",\r\n"
				+ "          \"legacyAttributeValue\": \"CONS\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"gtin14\": \"00086003813854\",\r\n"
				+ "      \"productDescription\": [\r\n"
				+ "        {\r\n"
				+ "          \"value\": \"YLWTAIL-WDBRDG PLLT SHPR\",\r\n"
				+ "          \"lang\": \"EN-US\"\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"productType\": \"EA\",\r\n"
				+ "      \"legacyData\": [\r\n"
				+ "        {\r\n"
				+ "          \"legacySystemId\": \"PID\",\r\n"
				+ "          \"legacyEntityId\": \"NONE\",\r\n"
				+ "          \"legacyAttributeName\": \"UPCTYPE\",\r\n"
				+ "          \"legacyAttributeValue\": \"CONS\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"gtin14\": \"00086003863866\",\r\n"
				+ "      \"productDescription\": [\r\n"
				+ "        {\r\n"
				+ "          \"value\": \"YLWTAIL-WDBRDG PLLT SHPR\",\r\n"
				+ "          \"lang\": \"EN-US\"\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"productType\": \"EA\",\r\n"
				+ "      \"legacyData\": [\r\n"
				+ "        {\r\n"
				+ "          \"legacySystemId\": \"PID\",\r\n"
				+ "          \"legacyEntityId\": \"NONE\",\r\n"
				+ "          \"legacyAttributeName\": \"UPCTYPE\",\r\n"
				+ "          \"legacyAttributeValue\": \"CONS\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"gtin14\": \"00086003873889\",\r\n"
				+ "      \"productDescription\": [\r\n"
				+ "        {\r\n"
				+ "          \"value\": \"YLWTAIL-WDBRDG PLLT SHPR\",\r\n"
				+ "          \"lang\": \"EN-US\"\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"productType\": \"EA\",\r\n"
				+ "      \"legacyData\": [\r\n"
				+ "        {\r\n"
				+ "          \"legacySystemId\": \"PID\",\r\n"
				+ "          \"legacyEntityId\": \"NONE\",\r\n"
				+ "          \"legacyAttributeName\": \"UPCTYPE\",\r\n"
				+ "          \"legacyAttributeValue\": \"CONS\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"gtin14\": \"00839743001582\",\r\n"
				+ "      \"productDescription\": [\r\n"
				+ "        {\r\n"
				+ "          \"value\": \"YLWTAIL-WDBRDG PLLT SHPR\",\r\n"
				+ "          \"lang\": \"EN-US\"\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"productType\": \"EA\",\r\n"
				+ "      \"legacyData\": [\r\n"
				+ "        {\r\n"
				+ "          \"legacySystemId\": \"PID\",\r\n"
				+ "          \"legacyEntityId\": \"NONE\",\r\n"
				+ "          \"legacyAttributeName\": \"UPCTYPE\",\r\n"
				+ "          \"legacyAttributeValue\": \"CONS\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"gtin14\": \"10031259999996\",\r\n"
				+ "      \"productDescription\": [\r\n"
				+ "        {\r\n"
				+ "          \"value\": \"YLWTAIL-WDBRDG PLLT SHPR\",\r\n"
				+ "          \"lang\": \"EN-US\"\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"productType\": \"CA\",\r\n"
				+ "      \"legacyData\": [\r\n"
				+ "        {\r\n"
				+ "          \"legacySystemId\": \"PID\",\r\n"
				+ "          \"legacyEntityId\": \"NONE\",\r\n"
				+ "          \"legacyAttributeName\": \"UPCTYPE\",\r\n"
				+ "          \"legacyAttributeValue\": \"CASE\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"legacySystemId\": \"PID\",\r\n"
				+ "          \"legacyEntityId\": \"PIDPDTCA\",\r\n"
				+ "          \"legacyAttributeName\": \"CAS_DSC_TX\",\r\n"
				+ "          \"legacyAttributeValue\": \"YLWTAIL-WDBRDG PLLT SHPR\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"packageHierarchy\": {\r\n"
				+ "    \"parentItem\": [\r\n"
				+ "      {\r\n"
				+ "        \"gtin\": \"10031259999996\",\r\n"
				+ "        \"numberOfUniqueGtins\": \"10\",\r\n"
				+ "        \"childItem\": [\r\n"
				+ "          {\r\n"
				+ "            \"gtin\": \"00031259008936\",\r\n"
				+ "            \"quantity\": 48\r\n"
				+ "          },\r\n"
				+ "          {\r\n"
				+ "            \"gtin\": \"00031259008950\",\r\n"
				+ "            \"quantity\": 36\r\n"
				+ "          },\r\n"
				+ "          {\r\n"
				+ "            \"gtin\": \"00031259009230\",\r\n"
				+ "            \"quantity\": 30\r\n"
				+ "          },\r\n"
				+ "          {\r\n"
				+ "            \"gtin\": \"00031259009469\",\r\n"
				+ "            \"quantity\": 24\r\n"
				+ "          },\r\n"
				+ "          {\r\n"
				+ "            \"gtin\": \"00031259999999\",\r\n"
				+ "            \"quantity\": 1\r\n"
				+ "          },\r\n"
				+ "          {\r\n"
				+ "            \"gtin\": \"00086003000506\",\r\n"
				+ "            \"quantity\": 12\r\n"
				+ "          },\r\n"
				+ "          {\r\n"
				+ "            \"gtin\": \"00086003813854\",\r\n"
				+ "            \"quantity\": 30\r\n"
				+ "          },\r\n"
				+ "          {\r\n"
				+ "            \"gtin\": \"00086003863866\",\r\n"
				+ "            \"quantity\": 18\r\n"
				+ "          },\r\n"
				+ "          {\r\n"
				+ "            \"gtin\": \"00086003873889\",\r\n"
				+ "            \"quantity\": 14\r\n"
				+ "          },\r\n"
				+ "          {\r\n"
				+ "            \"gtin\": \"00839743001582\",\r\n"
				+ "            \"quantity\": 6\r\n"
				+ "          }\r\n"
				+ "        ]\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
	//	Student student = mapper.readValue(json,Student.class);
		/*JsonNode node = mapper.readTree(json);
		String patch =" [{ \"op\": \"test\", \"path\": \"/name\", \"value\": \"prasanna\"}]";
		List<String> list = new ArrayList<>();
		list.add("/name");
		list.add("/products/0/familyTree");
		list.forEach((path)->{
			JsonPointer pointer;
			try {
				pointer = new JsonPointer(path);
				System.out.println(pointer.get(node));
			} catch (JsonPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});*/
		String path = "$.products[?((@.familyTree !=null||@.legacyData!=null)&&@.gtin14!=null)]";
		//String path = "$.products[*] ";
		List<Product> products = JsonPath.parse(json).read(path);
		//System.out.println(products);
		
		//error if the attribute is not there
		
		//JsonPatch jsonPatch = JsonPatch.fromJson(mapper.readTree(patch)) ;
		//JsonNode node =jsonPatch.apply(mapper.readTree(json));
		//System.out.println(mapper.writeValueAsString(node));
		
		List<String> paths = mp.get("PIM");
		List<Product> products2 = JsonPath.parse(json).read(paths.get(0));
		
		//List<String> result = paths.stream().filter((p)-> checkJsonPath(p,json)==0).collect(Collectors.toList());
		//System.out.println(result);
		System.out.println(checkJsonPaths(paths,json,0));
		
	}
	
	private static Object checkJsonPaths(List<String> paths,String json,int index) throws Exception {
		if(!StringUtils.hasText(json)) return json;
		if(index > paths.size()-1) return json;
		 ReadContext ctx = JsonPath.parse(json, com.jayway.jsonpath.Configuration.defaultConfiguration().addOptions(Option.SUPPRESS_EXCEPTIONS));//,Option.DEFAULT_PATH_LEAF_TO_NULL));
			Object p = ctx.read(paths.get(index));
			
			p =  checkJsonPaths(paths,new ObjectMapper().writeValueAsString(p),index+1);
			System.out.println(p);
			return p;
	}
	
	private static int checkJsonPath(String path,String json) {
		 ReadContext ctx = JsonPath.parse(json, com.jayway.jsonpath.Configuration.defaultConfiguration().addOptions(Option.SUPPRESS_EXCEPTIONS));//,Option.DEFAULT_PATH_LEAF_TO_NULL));
			List<Object> p = ctx.read(path);
			System.out.println(p);
			return p.size();
		
	}
}
