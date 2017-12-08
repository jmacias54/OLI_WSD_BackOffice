/**
 * 
 */
package mx.com.amx.unotv.oli.wsd.backoffice.dao;

import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import mx.com.amx.unotv.oli.wsd.backoffice.dao.exception.NNotaDAOException;
import mx.com.amx.unotv.oli.wsd.backoffice.response.ItemResponse;
import mx.com.amx.unotv.oli.wsd.backoffice.response.MagazineResponse;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class NNotaDAO {
	private static Logger logger = Logger.getLogger(NNotaDAO.class);

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public List<ItemResponse> findAll(Integer limit) throws NNotaDAOException {
		logger.info("--- findAll  [NNotaDAO] ---- ");
		logger.info("---  limit : "+limit);

		List<ItemResponse> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT nota.FC_ID_CONTENIDO fc_id_contenido, ");
		query.append(" 	      nota.FC_ID_CATEGORIA fc_id_categoria, ");
		query.append("        nota.FC_TIPO_NOTA fc_tipo_nota, ");
		query.append("        nota.FC_ID_CLASS_VIDEO fc_id_class_video, ");
		query.append(" 	      nota.FC_TITULO fc_titulo, ");
		query.append("        nota.FC_DESCRIPCION fc_descripcion, ");
		query.append("        nota.FC_FRIENDLY_URL fc_friendy_url, ");
		query.append("        nota.FC_IMAGEN fc_imagen, ");
		query.append("        nota.FD_FECHA_PUBLICACION fc_fecha_publicacion, ");
		query.append("        categotia.FC_DESCRIPCION fc_descripcion_categoria ");
		query.append(" FROM OLI_MX_N_NOTA nota");
		query.append(" INNER JOIN oli_mx_c_categoria categotia ON nota.FC_ID_CATEGORIA = categotia.FC_ID_CATEGORIA");
		query.append(" ORDER BY nota.FD_FECHA_PUBLICACION DESC ");
		query.append(" LIMIT "+limit+" ");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<ItemResponse>(ItemResponse.class));

		} catch (Exception e) {

			logger.error(" Error findAll [ NNotaDAO ] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		if (lista.isEmpty() || lista == null) {
			return Collections.emptyList();
		}

		return lista;
	}
	
	
		
	public List<ItemResponse> findByIdCategoria(String idCategoria) throws NNotaDAOException {
		logger.info("--- findByIdCategoria  [NNotaDAO] ---- ");
		logger.info("---  idCategoria : "+idCategoria);
	

		List<ItemResponse> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT nota.FC_ID_CONTENIDO fc_id_contenido, ");
		query.append(" 	      nota.FC_ID_CATEGORIA fc_id_categoria, ");
		query.append("        nota.FC_TIPO_NOTA fc_tipo_nota, ");
		query.append("        nota.FC_ID_CLASS_VIDEO fc_id_class_video, ");
		query.append(" 	      nota.FC_TITULO fc_titulo, ");
		query.append("        nota.FC_DESCRIPCION fc_descripcion, ");
		query.append("        nota.FC_FRIENDLY_URL fc_friendy_url, ");
		query.append("        nota.FC_IMAGEN fc_imagen, ");
		query.append("        nota.FD_FECHA_PUBLICACION fc_fecha_publicacion, ");
		query.append("        categotia.FC_DESCRIPCION fc_descripcion_categoria ");
		query.append(" FROM OLI_MX_N_NOTA nota");
		query.append(" INNER JOIN oli_mx_c_categoria categotia ON nota.FC_ID_CATEGORIA = categotia.FC_ID_CATEGORIA");
		query.append("  WHERE nota.FC_ID_CATEGORIA ='" + idCategoria + "'");
		query.append(" ORDER BY nota.FD_FECHA_PUBLICACION DESC ");
	

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<ItemResponse>(ItemResponse.class));

		} catch (Exception e) {

			logger.error(" Error findByIdCategoria [ NNotaDAO ] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		if (lista.isEmpty() || lista == null) {
			return Collections.emptyList();
		}

		return lista;
	}
	
	
	public List<ItemResponse> findByIdCategoria(String idCategoria,Integer limit) throws NNotaDAOException {
		logger.info("--- findByIdCategoria  [NNotaDAO] ---- ");
		logger.info("---  idCategoria : "+idCategoria);
		logger.info("---  limit : "+limit);

		List<ItemResponse> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT nota.FC_ID_CONTENIDO fc_id_contenido, ");
		query.append(" 	      nota.FC_ID_CATEGORIA fc_id_categoria, ");
		query.append("        nota.FC_TIPO_NOTA fc_tipo_nota, ");
		query.append("        nota.FC_ID_CLASS_VIDEO fc_id_class_video, ");
		query.append(" 	      nota.FC_TITULO fc_titulo, ");
		query.append("        nota.FC_DESCRIPCION fc_descripcion, ");
		query.append("        nota.FC_FRIENDLY_URL fc_friendy_url, ");
		query.append("        nota.FC_IMAGEN fc_imagen, ");
		query.append("        nota.FD_FECHA_PUBLICACION fc_fecha_publicacion, ");
		query.append("        categotia.FC_DESCRIPCION fc_descripcion_categoria ");
		query.append(" FROM OLI_MX_N_NOTA nota");
		query.append(" INNER JOIN oli_mx_c_categoria categotia ON nota.FC_ID_CATEGORIA = categotia.FC_ID_CATEGORIA");
		query.append(" WHERE nota.FC_ID_CATEGORIA ='" + idCategoria + "'");
		query.append(" ORDER BY nota.FD_FECHA_PUBLICACION DESC ");
		query.append(" LIMIT "+limit+" ");

	

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<ItemResponse>(ItemResponse.class));

		} catch (Exception e) {

			logger.error(" Error findByIdCategoria [ NNotaDAO ] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		if (lista.isEmpty() || lista == null) {
			return Collections.emptyList();
		}

		return lista;
	}

	public List<ItemResponse> findByTipoNota(String tipoNota) throws NNotaDAOException {
		logger.info("--- findByTipoNota  [NNotaDAO] ---- ");
		logger.info("---  tipoNota : "+tipoNota);
		

		List<ItemResponse> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT nota.FC_ID_CONTENIDO fc_id_contenido, ");
		query.append(" 	      nota.FC_ID_CATEGORIA fc_id_categoria, ");
		query.append("        nota.FC_TIPO_NOTA fc_tipo_nota, ");
		query.append("        nota.FC_ID_CLASS_VIDEO fc_id_class_video, ");
		query.append(" 	      nota.FC_TITULO fc_titulo, ");
		query.append("        nota.FC_DESCRIPCION fc_descripcion, ");
		query.append("        nota.FC_FRIENDLY_URL fc_friendy_url, ");
		query.append("        nota.FC_IMAGEN fc_imagen, ");
		query.append("        nota.FD_FECHA_PUBLICACION fc_fecha_publicacion, ");
		query.append("        categotia.FC_DESCRIPCION fc_descripcion_categoria ");
		query.append(" FROM OLI_MX_N_NOTA nota");
		query.append(" INNER JOIN oli_mx_c_categoria categotia ON nota.FC_ID_CATEGORIA = categotia.FC_ID_CATEGORIA");
		query.append(" WHERE nota.FC_TIPO_NOTA ='" + tipoNota + "'");
		query.append(" ORDER BY nota.FD_FECHA_PUBLICACION DESC ");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<ItemResponse>(ItemResponse.class));

		} catch (Exception e) {

			logger.error(" Error findByTipoNota [ NNotaDAO ] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		if (lista.isEmpty() || lista == null) {
			return Collections.emptyList();
		}

		return lista;
	}

	public List<ItemResponse> findByIdClassVideo(String idClassVideo) throws NNotaDAOException {
		logger.info("--- findByIdClassVideo  [NNotaDAO] ---- ");
		logger.info("---  idClassVideo : "+idClassVideo);
		
	
		List<ItemResponse> lista = null;

	
		StringBuilder query = new StringBuilder();
		query.append(" SELECT nota.FC_ID_CONTENIDO fc_id_contenido, ");
		query.append(" 	      nota.FC_ID_CATEGORIA fc_id_categoria, ");
		query.append("        nota.FC_TIPO_NOTA fc_tipo_nota, ");
		query.append("        nota.FC_ID_CLASS_VIDEO fc_id_class_video, ");
		query.append(" 	      nota.FC_TITULO fc_titulo, ");
		query.append("        nota.FC_DESCRIPCION fc_descripcion, ");
		query.append("        nota.FC_FRIENDLY_URL fc_friendy_url, ");
		query.append("        nota.FC_IMAGEN fc_imagen, ");
		query.append("        nota.FD_FECHA_PUBLICACION fc_fecha_publicacion, ");
		query.append("        categotia.FC_DESCRIPCION fc_descripcion_categoria ");
		query.append(" FROM OLI_MX_N_NOTA nota");
		query.append(" INNER JOIN oli_mx_c_categoria categotia ON nota.FC_ID_CATEGORIA = categotia.FC_ID_CATEGORIA");
		query.append(" WHERE nota.FC_ID_CLASS_VIDEO ='" + idClassVideo + "'");
		query.append(" ORDER BY nota.FD_FECHA_PUBLICACION DESC ");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<ItemResponse>(ItemResponse.class));

		} catch (Exception e) {

			logger.error(" Error findByIdClassVideo [ NNotaDAO ] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		if (lista.isEmpty() || lista == null) {
			return Collections.emptyList();
		}

		return lista;
	}
	
	
	public List<ItemResponse> findByIdClassVideo(String idClassVideo, Integer limit) throws NNotaDAOException {
		logger.info("--- findByIdClassVideo  [NNotaDAO] ---- ");
		logger.info("---  idClassVideo : "+idClassVideo);
		logger.info("---  limit : "+limit);
	
		List<ItemResponse> lista = null;

	
		StringBuilder query = new StringBuilder();
		query.append(" SELECT nota.FC_ID_CONTENIDO fc_id_contenido, ");
		query.append(" 	      nota.FC_ID_CATEGORIA fc_id_categoria, ");
		query.append("        nota.FC_TIPO_NOTA fc_tipo_nota, ");
		query.append("        nota.FC_ID_CLASS_VIDEO fc_id_class_video, ");
		query.append(" 	      nota.FC_TITULO fc_titulo, ");
		query.append("        nota.FC_DESCRIPCION fc_descripcion, ");
		query.append("        nota.FC_FRIENDLY_URL fc_friendy_url, ");
		query.append("        nota.FC_IMAGEN fc_imagen, ");
		query.append("        nota.FD_FECHA_PUBLICACION fc_fecha_publicacion, ");
		query.append("        categotia.FC_DESCRIPCION fc_descripcion_categoria ");
		query.append(" FROM OLI_MX_N_NOTA nota");
		query.append(" INNER JOIN oli_mx_c_categoria categotia ON nota.FC_ID_CATEGORIA = categotia.FC_ID_CATEGORIA");
		query.append(" WHERE nota.FC_ID_CLASS_VIDEO ='" + idClassVideo + "'");
		query.append(" ORDER BY nota.FD_FECHA_PUBLICACION DESC ");
		query.append(" LIMIT "+limit+" ");
		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<ItemResponse>(ItemResponse.class));

		} catch (Exception e) {

			logger.error(" Error findByIdClassVideo [ NNotaDAO ] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		if (lista.isEmpty() || lista == null) {
			return Collections.emptyList();
		}

		return lista;
	}
	
	
	
	public List<MagazineResponse> findByMagazine(String idMagazine) throws NNotaDAOException {
		logger.info("--- findByMagazine  [NNotaDAO] ---- ");
		logger.info("---  idMagazine : "+idMagazine);
	

		List<MagazineResponse> lista = null;

		StringBuilder query = new StringBuilder();
		query.append(" SELECT nota.FC_ID_CONTENIDO fc_id_contenido, ");
		query.append(" 	      nota.FC_ID_CATEGORIA fc_id_categoria, ");
		query.append("        nota.FC_TIPO_NOTA fc_tipo_nota, ");
		query.append("        nota.FC_ID_CLASS_VIDEO fc_id_class_video, ");
		query.append(" 	      nota.FC_TITULO fc_titulo, ");
		query.append("        nota.FC_DESCRIPCION fc_descripcion, ");
		query.append("        nota.FC_FRIENDLY_URL fc_friendy_url, ");
		query.append("        nota.FC_IMAGEN fc_imagen, ");
		query.append("        nota.FD_FECHA_PUBLICACION fc_fecha_publicacion, ");
		query.append("        categotia.FC_DESCRIPCION fc_descripcion_categoria, ");
		query.append("        imagazine.FC_ID_MAGAZINE fc_id_magazine , ");
		query.append("        imagazine.FC_URL_EXTERNA fc_url_externa, ");
		query.append("        imagazine.FI_ORDEN fi_orden  ");
		query.append(" FROM OLI_MX_N_NOTA nota ");
		query.append(" INNER JOIN oli_mx_c_categoria categotia ON nota.FC_ID_CATEGORIA = categotia.FC_ID_CATEGORIA ");
		query.append(" INNER JOIN oli_mx_i_nota_magazine imagazine on nota.FC_ID_CONTENIDO = imagazine.FC_ID_CONTENIDO ");
		query.append(" WHERE imagazine.FC_ID_MAGAZINE ='" + idMagazine + "'   ORDER BY  imagazine.FI_ORDEN ");

		try {

			lista = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<MagazineResponse>(MagazineResponse.class));

		} catch (Exception e) {

			logger.error(" Error findByMagazine [ NNotaDAO ] ", e);

			throw new NNotaDAOException(e.getMessage());

		}

		if (lista.isEmpty() || lista == null) {
			return Collections.emptyList();
		}

		return lista;
	}

}
