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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.com.amx.unotv.oli.wsd.backoffice.controller.exception.ControllerException;
import mx.com.amx.unotv.oli.wsd.backoffice.dao.MagazineDAO;
import mx.com.amx.unotv.oli.wsd.backoffice.model.Magazine;
import mx.com.amx.unotv.oli.wsd.backoffice.response.ListResponse;



/**
 * @author Jesus A. Macias Benitez
 *
 */

@Controller
@RequestMapping("magazine")
public class MagazineController {

	/** The logger. */
	private static Logger logger = Logger.getLogger(MagazineController.class);
	
	
	@Autowired
	MagazineDAO magazineDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ListResponse<Magazine> findAll() throws ControllerException{
		logger.info("--- findAll [ MagazineController ]---- ");

		List<Magazine> lista = null;
		ListResponse<Magazine> response = null;

		try {

			lista = magazineDAO.findAll();

			if (lista != null && !lista.isEmpty()) {
				response = new ListResponse<Magazine>();
				response.setLista(lista);
			}else {
				
				response = new ListResponse<Magazine>();
				response.setLista(Collections.<Magazine>emptyList());
			}
			

		} catch (Exception e) {
			logger.error(" -- Error  findAll [ MagazineController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return response;
		
	}
	@RequestMapping(value = "/delete/{idMagazine}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public void delete(@PathVariable String idMagazine) throws ControllerException {
		logger.info("--- delete [ MagazineController ]---- ");
		try {

			 magazineDAO.delete(idMagazine);

		} catch (Exception e) {
			logger.error(" -- Error  delete [ MagazineController ]:", e);
			throw new ControllerException(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/{idMagazine}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public Magazine findById(@PathVariable String idMagazine) throws ControllerException {
		logger.info("--- findById [ MagazineController ]---- ");
		Magazine obj = null;

		try {

			obj = magazineDAO.findById(idMagazine);

		} catch (Exception e) {
			logger.error(" -- Error  findById [ MagazineController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return obj;
		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int insert(@RequestBody Magazine magazine) throws ControllerException {
		logger.info("--- insert [ MagazineController ]---- ");
		int result = 0;

		try {

			result = magazineDAO.insert(magazine);

		} catch (Exception e) {
			logger.error(" -- Error  insert [ MagazineController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return result;
	}

}
