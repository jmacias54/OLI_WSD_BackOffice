/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.backoffice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import mx.com.amx.unotv.oli.wsd.backoffice.dao.NNotaDAO;


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

}
