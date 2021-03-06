package org.reactome.web.pwp.model.client.handlers;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface DBNameRetrievedHandler {
    void onDBNameRetrieved(String version);
    void onDBNameRetrievedError(Throwable ex);
}
