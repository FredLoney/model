package org.reactome.web.pwp.model.classes;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.resources.client.ImageResource;
import org.reactome.web.pwp.model.factory.SchemaClass;
import org.reactome.web.pwp.model.images.DatabaseObjectImages;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class Depolymerisation extends ReactionLikeEvent {

    public Depolymerisation() {
        super(SchemaClass.DEPOLYMERISATION);
    }

    @Override
    public void load(JSONObject jsonObject) {
        super.load(jsonObject);
    }

    @Override
    public ImageResource getImageResource() {
        return DatabaseObjectImages.INSTANCE.depolymerization();
    }
}
