/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Romain Fouchier
 */
@Path("generic")
public class RestServices {
    @Context
    private UriInfo context;
    
    Radio.Services serv;

    public RestServices() {
        serv = new Radio.Services(bureau.DatabaseUtils.fact());
    }
    
    @GET
    @Path("admission/{iep}")
    @Produces("application/json")
    public Admission getAdmissionById(@PathParam("iep") int iep) {
        return serv.getAdmissionById(iep);
    }
    
    @GET
    @Path("actes/{iep}")
    @Produces("application/json")
    public List<Acte> getActesByIEP(@PathParam("iep") int iep) {
        return serv.getActesByIEP(iep);
    }
    
    @GET
    @Path("actes/{ipp}")
    @Produces("patient/images")
    public List<Image> getImagesByIPP(@PathParam("ipp") int ipp) {
        return serv.getImagesByIPP(ipp);
    }
    
    @POST
    @Path("Acte")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Acte creerActe(Acte a) {
        return serv.creerActe(a);
    }
    
    @POST
    @Path("Modalite")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Modalite creerModalite(Modalite m) {
        return serv.creerModalite(m);
    }
    
}
