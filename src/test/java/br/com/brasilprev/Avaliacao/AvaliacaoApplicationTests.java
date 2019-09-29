package br.com.brasilprev.Avaliacao;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AvaliacaoApplicationTests {
	 @Autowired
	    private WebApplicationContext wac;
	 
	 private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
	 
	    @Autowired
	    private FilterChainProxy springSecurityFilterChain;
	    
	    private MockMvc mockMvc;
	    
	    @Before
	    public void setup() {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
	          .addFilter(springSecurityFilterChain).build();
	    }
	    
	    
	    private String obtainAccessToken(String username, String password) throws Exception {
	    	  
	        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
	        params.add("grant_type", "password");
	        params.add("client_id", "brasilprev_user_all_permission");
	        params.add("username", username);
	        params.add("password", password);
	     
	        ResultActions result 
	          = mockMvc.perform(post("/oauth/token")
	            .params(params)
	            .with(httpBasic("brasilprev_user_all_permission","admin1234"))
	            .accept("application/json;charset=UTF-8"))
	            .andExpect(status().isOk())
	            .andExpect(content().contentType("application/json;charset=UTF-8"));
	     
	        String resultString = result.andReturn().getResponse().getContentAsString();
	     
	        JacksonJsonParser jsonParser = new JacksonJsonParser();
	        return jsonParser.parseMap(resultString).get("access_token").toString();
	    }

	
	
	    @Test
	    public void sendGetWhenNotAuthorized() throws Exception {
	        mockMvc.perform(get("/brasilPrevContextPatternSecured/categoria/getCategoria").param("id", "1")).andExpect(status().isUnauthorized());
	    }

//	    @Test
//	    public void tentativa_salvar_com_tokenIndevido() throws Exception {
//	        final String accessToken = obtainAccessToken("abestalhado", "teste1234");
//	       System.out.println("token:" + accessToken);
//	        mockMvc.perform(get("/brasilPrevContextPatternSecured/categoria/getCategoria").header("Authorization", "Bearer " + accessToken).param("id", "2")).andExpect(status().is4xxClientError());
//	    }

	    @Test
	    public void tenta_salvar_categoria_token_valido() throws Exception {
	        String accessToken = obtainAccessToken("adminapi", "admin1234");
	        
	        String categorias = "{ \"categoria\": \"teste\",  \"dataExclusao\": \"\",  \"id\": 0}";
	             
	        mockMvc.perform(post("/brasilPrevContextPatternSecured/pedido/savePedido")
	          .header("Authorization", "Bearer " + accessToken)
	          .contentType(CONTENT_TYPE)
	          .content(categorias)
	          .accept(CONTENT_TYPE))
	          .andExpect(status().is2xxSuccessful());


	    
	    }
	    
	    
	    @Test
	    public void tenta_salvar_cliente_token_valido() throws Exception {
	        String accessToken = obtainAccessToken("adminapi", "admin1234");
	        
	        String categorias = "{\"bairro\": \"Brotas\",  \"cep\": \"40320040\",  \"cidade\": \"SALVADOR\",  \"dataExclusao\": \"null\",  \"email\": \"larinha@gmail.com\",  \"estado\": \"bahia\",  \"id\": 0,  \"nome\": \"DIEGO PITA\",  \"rua\": \"ENGENHEIRO\",  \"senha\": \"NAO É DE\"}";
	             
	        mockMvc.perform(post("/brasilPrevContextPatternSecured/clientes/saveCliente")
	          .header("Authorization", "Bearer " + accessToken)
	          .contentType(CONTENT_TYPE)
	          .content(categorias)
	          .accept(CONTENT_TYPE))
	          .andExpect(status().is2xxSuccessful());


	    
	    }
	    
//	    @Test
//	    public void tenta_salvar_produto() throws Exception {
//	        String accessToken = obtainAccessToken("adminapi", "admin1234");
//	        {
//	        String produto = "{\"categoria\": {    \"categoria\": \"BAIRRO teste\",    \"dataExclusao\": \"null\",    \"id\": 0  },  \"dataExclusao\": \"null\",  \"descricao\": \"VINAGRE DE MACA\",  \"id\": 0,  \"imagem\": \"null\",  \"preco\": 3,  \"produto\": \"VINAGRE DE MACA PARA FAZER VINHO TINTO\",  \"quantidade\": 4}";
//	             
//	        mockMvc.perform(post("/brasilPrevContextPatternSecured/produtos/saveProduto")
//	          .header("Authorization", "Bearer " + accessToken)
//	          .contentType(CONTENT_TYPE)
//	          .content(produto)
//	          .accept(CONTENT_TYPE))
//	          .andExpect(status().is2xxSuccessful());
//
//
//	    
//	    }}
	        
	        
	        @Test
		    public void tenta_salvar_pedido() throws Exception {
		        String accessToken = obtainAccessToken("adminapi", "admin1234");
		        {
		        String pedido = "{  \"cliente\": {    \"bairro\": \"sao cristovia\",    \"cep\": \"2333\",    \"cidade\": \"salvador\",    \"dataExclusao\": \"null\",    \"email\": \"dpitap@gmail.com\",    \"estado\": \"string\",    \"id\": 0,    \"nome\": \"string\",    \"rua\": \"string\",    \"senha\": \"string\"  },  \"dataExclusao\": \"null\",  \"id\": 0,  \"sessao\": \"alimentos\",  \"status\": \"feitao\"}";
		        mockMvc.perform(post("/brasilPrevContextPatternSecured/produtos/saveProduto")
		          .header("Authorization", "Bearer " + accessToken)
		          .contentType(CONTENT_TYPE)
		          .content(pedido)
		          .accept(CONTENT_TYPE))
		          .andExpect(status().is2xxSuccessful());


		    
		    }
	    }
	    
}
