/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.backoffice.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.com.amx.unotv.oli.wsd.backoffice.controller.exception.ControllerException;
import mx.com.amx.unotv.oli.wsd.backoffice.dao.IMagazineDAO;
import mx.com.amx.unotv.oli.wsd.backoffice.model.IMagazine;

/**
 * @author Jesus A. Macias Benitez
 *
 */

@Controller
@RequestMapping("iMagazine")
public class IMagazineController {
	/** The logger. */
	private static Logger logger = Logger.getLogger(IMagazineController.class);

	@Autowired
	IMagazineDAO iMagazineDAO;

	@RequestMapping(value = "/{idMagazine}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public IMagazine findById(@PathVariable String idMagazine) throws ControllerException {
		logger.info("--- findById [ IMagazineController ]---- ");
		IMagazine obj = null;

		try {

			obj = iMagazineDAO.findById(idMagazine);

		} catch (Exception e) {
			logger.error(" -- Error  findById [ IMagazineController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return obj;
	}

	@RequestMapping(value = "/delete/{idMagazine}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public void delete(@PathVariable String idMagazine) throws ControllerException {
		logger.info("--- delete [ IMagazineController ]---- ");
		try {

			iMagazineDAO.delete(idMagazine);

		} catch (Exception e) {
			logger.error(" -- Error  delete [ IMagazineController ]:", e);
			throw new ControllerException(e.getMessage());
		}
	}



	@RequestMapping(value = "/insert", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int insert(@RequestBody IMagazine imagazine) throws ControllerException {
		logger.info("--- insert [ IMagazineController ]---- ");
		int result = 0;

		try {

			result = iMagazineDAO.insert(imagazine);

		} catch (Exception e) {
			logger.error(" -- Error  insert [ IMagazineController ]:", e);
			throw new ControllerException(e.getMessage());
		}

		return result;

	}

}
