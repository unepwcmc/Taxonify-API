package org.unepwcmc.taxonifyapi.resources;

import io.dropwizard.jersey.params.LongParam;
import org.unepwcmc.taxonifyapi.dao.Distribution;
import org.unepwcmc.taxonifyapi.dao.DistributionDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/distribution/{speciesId}")
@Produces(MediaType.APPLICATION_JSON)
public class DistributionResource {
    private final DistributionDAO dao;

    public DistributionResource(DistributionDAO dao) {
        this.dao = dao;
    }

    @GET
    public List<Distribution> getTaxon(@PathParam("speciesId") LongParam speciesId) {
        return dao.distributionFor(speciesId.get());
    }
}