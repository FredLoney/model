package org.reactome.web.pwp.model.classes;

import com.google.gwt.json.client.JSONObject;
import org.reactome.web.pwp.model.factory.DatabaseObjectFactory;
import org.reactome.web.pwp.model.factory.DatabaseObjectUtils;
import org.reactome.web.pwp.model.factory.SchemaClass;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
@SuppressWarnings("UnusedDeclaration")
public class DatabaseIdentifier extends DatabaseObject {
    private String identifier;
    private List<DatabaseIdentifier> crossReference;
    private ReferenceDatabase referenceDatabase;
    private String url; // Valid URL based on referenceDatabase

    public DatabaseIdentifier() {
        super(SchemaClass.DATABASE_IDENTIFIER);
    }

    @Override
    public void load(JSONObject jsonObject) {
        super.load(jsonObject);

        if (jsonObject.containsKey("identifier")) {
            this.identifier = DatabaseObjectUtils.getStringValue(jsonObject, "identifier");
        }

        this.crossReference = new LinkedList<>();
        for (JSONObject object : DatabaseObjectUtils.getObjectList(jsonObject, "crossReference")) {
            this.crossReference.add((DatabaseIdentifier) DatabaseObjectFactory.create(object));
        }

        if (jsonObject.containsKey("referenceDatabase")) {
            this.referenceDatabase = DatabaseObjectUtils.getDatabaseObject(jsonObject, "referenceDatabase");
        }

        if (jsonObject.containsKey("url")) {
            this.url = DatabaseObjectUtils.getStringValue(jsonObject, "url");
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<DatabaseIdentifier> getCrossReference() {
        return crossReference;
    }

    public ReferenceDatabase getReferenceDatabase() {
        return referenceDatabase;
    }

    public String getUrl() {
        return url;
    }
}
