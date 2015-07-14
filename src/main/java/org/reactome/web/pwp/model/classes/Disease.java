package org.reactome.web.pwp.model.classes;

import com.google.gwt.json.client.JSONObject;
import org.reactome.web.pwp.model.factory.SchemaClass;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class Disease extends ExternalOntology {

    public Disease() {
        super(SchemaClass.DISEASE);
    }

    @Override
    public void load(JSONObject jsonObject) {
        super.load(jsonObject);
    }
}
