/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.backoffice.controller;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.com.amx.unotv.oli.wsd.backoffice.controller.exception.ControllerException;
import mx.com.amx.unotv.oli.wsd.backoffice.dao.NNotaDAO;
import mx.com.amx.unotv.oli.wsd.backoffice.model.NNota;
import mx.com.amx.unotv.oli.wsd.backoffice.response.ItemResponse;
import mx.com.amx.unotv.oli.wsd.backoffice.response.ListResponse;
import mx.com.amx.unotv.oli.wsd.backoffice.response.MagazineResponse;


/**
 * @author Jesus A. Macias Benitez
 *
 */


@Controller
@RequestMapping("nNota")
public class NNotaController {
	/** The logger. */
	private static Logger logger = Logger.getLogger(NNotaController.class);
	
	@Autowired
	NNotaDAO nNotaDAO;
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ListResponse<NNota> findAll() throws ControllerException{
		
		logger.info("--- findAll [ NNotaController ]---- ");

		List<NNota> lista = null;
		ListResponse<NNota> response = null;

		try {

			lista = nNotaDAO.findAll();

			if (lista != null && !lista.isEmpty()) {
				response = new ListResponse<NNota>();
				response.setLista(lista);
			}else {
				
				response = new ListResponse<NNota>();
				response.setLista(Collections.<NNota>emptyList());
			}

		} catch (Exception e) {
			logger.error(" -- Error  findAll [ NNotaController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}

	@RequestMapping(value = "/categoria/{idCategoria}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ListResponse<ItemResponse> findByIdCategoria(@PathVariable String idCategoria) throws ControllerException {
		
		logger.info("--- findByIdCategoria [ NNotaController ]---- ");

		List<ItemResponse> lista = null;
		ListResponse<ItemResponse> response = null;

		try {

			lista = nNotaDAO.findByIdCategoria(idCategoria);

			if (lista != null && !lista.isEmpty()) {
				response = new ListResponse<ItemResponse>();
				response.setLista(lista);
			}else {
				
				response = new ListResponse<ItemResponse>();
				response.setLista(Collections.<ItemResponse>emptyList());
			}

		} catch (Exception e) {
			logger.error(" -- Error  findByIdCategoria [ NNotaController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}
	
	@RequestMapping(value = "/tipoNota/{tipoNota}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ListResponse<ItemResponse> findByTipoNota(@PathVariable String tipoNota) throws ControllerException {
		logger.info("--- findByTipoNota [ NNotaController ]---- ");

		List<ItemResponse> lista = null;
		ListResponse<ItemResponse> response = null;

		try {

			lista = nNotaDAO.findByTipoNota(tipoNota);

			if (lista != null && !lista.isEmpty()) {
				response = new ListResponse<ItemResponse>();
				response.setLista(lista);
			}else {
				
				response = new ListResponse<ItemResponse>();
				response.setLista(Collections.<ItemResponse>emptyList());
			}

		} catch (Exception e) {
			logger.error(" -- Error  findByTipoNota [ NNotaController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
	}
	
	@RequestMapping(value = "/classVideo/{idClassVideo}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ListResponse<ItemResponse> findByIdClassVideo(@PathVariable String idClassVideo) throws ControllerException {
		logger.info("--- findByIdClassVideo [ NNotaController ]---- ");

		List<ItemResponse> lista = null;
		ListResponse<ItemResponse> response = null;

		try {

			lista = nNotaDAO.findByIdClassVideo(idClassVideo);

			if (lista != null && !lista.isEmpty()) {
				response = new ListResponse<ItemResponse>();
				response.setLista(lista);
			}else {
				
				response = new ListResponse<ItemResponse>();
				response.setLista(Collections.<ItemResponse>emptyList());
			}

		} catch (Exception e) {
			logger.error(" -- Error  findByIdClassVideo [ NNotaController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
		
	}
	
	
	@RequestMapping(value = "/magazine/{idMagazine}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ListResponse<MagazineResponse> findByMagazine(@PathVariable String idMagazine) throws ControllerException {
		logger.info("--- findByMagazine [ NNotaController ]---- ");

		List<MagazineResponse> lista = null;
		ListResponse<MagazineResponse> response = null;

		try {

			lista = nNotaDAO.findByMagazine(idMagazine);

			if (lista != null && !lista.isEmpty()) {
				response = new ListResponse<MagazineResponse>();
				response.setLista(lista);
			}else {
				
				response = new ListResponse<MagazineResponse>();
				response.setLista(Collections.<MagazineResponse>emptyList());
			}

		} catch (Exception e) {
			logger.error(" -- Error  findByMagazine [ NNotaController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
		
	}
}
