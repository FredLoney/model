package org.reactome.web.pwp.model.client;

import org.reactome.web.pwp.model.client.classes.DatabaseObject;
import org.reactome.web.pwp.model.client.classes.Pathway;
import org.reactome.web.pwp.model.client.common.ContentClientHandler;
import org.reactome.web.pwp.model.client.common.GWTTestCaseCommon;
import org.reactome.web.pwp.model.client.content.ContentClient;
import org.reactome.web.pwp.model.client.content.ContentClientError;

import java.util.Arrays;
import java.util.Map;


/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class GwtTestBasicContentServiceQueries extends GWTTestCaseCommon {

    public void testBasicObjectFactoryUseCase() {
        // Since RPC calls are asynchronous, we will need to wait for a response
        // after this test method returns. This line tells the test runner to wait
        // up to 2.5 seconds before timing out.
        delayTestFinish(2500);

        String stId = "R-HSA-199420";
        ContentClient.query("R-HSA-199420", new ContentClientHandler.ObjectReady() {
            @Override
            public void onObjectReady(DatabaseObject databaseObject) {
                assertTrue("The stId has to be `" + stId + "'. Found: '" + databaseObject.getStId() + "'", databaseObject.getStId().equals(stId));
                finishTest();
            }

            @Override
            public void onContentClientException(Type type, String message) {
                fail(type + " " + message);
            }

            @Override
            public void onContentClientError(ContentClientError error) {
                fail(error.getMessage().toString());
            }
        });
    }

    public void testDatabaseObjectLoad() {
        // Since RPC calls are asynchronous, we will need to wait for a response
        // after this test method returns. This line tells the test runner to wait
        // up to 2.5 seconds before timing out.
        delayTestFinish(2500);

        ContentClient.query("R-HSA-1640170", new ContentClientHandler.ObjectReady() {
            @Override
            public void onObjectReady(DatabaseObject databaseObject) {
                Pathway p = databaseObject.cast();
                assertFalse(p.getOrthologousEvent().isEmpty());

                Pathway orth = p.getOrthologousEvent().get(0).cast();
                assertTrue(orth.getCreated() == null);

                orth.load(new ObjectReady() {
                    @Override
                    public void onObjectReady(DatabaseObject databaseObject) {
                        Pathway orth = databaseObject.cast();
                        assertTrue(orth.getCreated() != null);
                        finishTest();
                    }

                    @Override
                    public void onContentClientException(Type type, String message) {
                        fail(type + " " + message);
                    }

                    @Override
                    public void onContentClientError(ContentClientError error) {
                        fail(error.getMessage().toString());
                    }
                });
                finishTest();
            }

            @Override
            public void onContentClientException(Type type, String message) {
                fail(type + " " + message);
            }

            @Override
            public void onContentClientError(ContentClientError error) {
                fail(error.getMessage().toString());
            }
        });
    }

    public void testQueryIdsMap() {
        // Since RPC calls are asynchronous, we will need to wait for a response
        // after this test method returns. This line tells the test runner to wait
        // up to 2.5 seconds before timing out.
        delayTestFinish(2500);

        ContentClient.query(Arrays.asList("REACT_13", "R-HSA-199420", "1368092"), new ContentClientHandler.ObjectListLoaded() {
            @Override
            public void onObjectListLoaded(Map<String, DatabaseObject> databaseObjects) {
                assertTrue(databaseObjects.get("REACT_13") != null);
                assertTrue(databaseObjects.get("REACT_13").getStId().equals("R-HSA-71291"));

                assertTrue(databaseObjects.get("R-HSA-199420") != null);
                assertTrue(databaseObjects.get("R-HSA-199420").getDbId().equals(199420L));

                assertTrue(databaseObjects.get("1368092") != null);
                assertTrue(databaseObjects.get("1368092").getStId().equals("R-MMU-1368092"));
                finishTest();
            }

            @Override
            public void onContentClientException(Type type, String message) {
                fail(type + " " + message);
            }

            @Override
            public void onContentClientError(ContentClientError error) {
                fail(error.getMessage().toString());
            }
        });

    }
}