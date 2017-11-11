package co.com.kallsonys.helpers;

import java.util.ArrayList;
import java.util.List;

import co.com.kallsonys.dto.ProductsDTO;
import co.com.kallsonys.dto.request.CreateProductRequestDTO;
import co.com.kallsonys.entity.Producers;
import co.com.kallsonys.entity.Products;
import co.com.kallsonys.entity.Status;

/**
 * @author Generated
 * @version 3.0 - Wed Oct 07 11:02:59 COT 2015
 */
public class ProductsHelper {

	public static Products buildProdutsEntity(CreateProductRequestDTO productRequest, Boolean isUpdate) {

		Products product = new Products();

		if (isUpdate) {
			product.setId(productRequest.getId());
		}

		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());
		product.setExternalidentifier(productRequest.getExternalIdentifier());

		product.setStatus(new Status());
		product.getStatus().setId(productRequest.getIdStatus());

		product.setIdproducer(new Producers());
		product.getIdproducer().setId(productRequest.getIdProducer());

		return product;

	}

}
