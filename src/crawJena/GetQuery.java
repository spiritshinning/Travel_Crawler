package crawJena;

import org.apache.jena.query.ParameterizedSparqlString;

public class GetQuery {
    public GetQuery() {
    }

    private final String location = "http://dbpedia.org/sparql";

    public String Relocation() {
        return this.location;
    }

    public ParameterizedSparqlString getQuery(String text) {
        ParameterizedSparqlString queryStr = new ParameterizedSparqlString();
        queryStr.setNsPrefix("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        queryStr.setNsPrefix("rdfs", "http://www.w3.org/2000/01/rdf-schema#");
        queryStr.setNsPrefix("dbo", "http://dbpedia.org/ontology/");
        queryStr.setNsPrefix("dbr", "http://dbpedia.org/resource/");
        queryStr.setNsPrefix("dbc", "http://dbpedia.org/resource/Category:");
        queryStr.setNsPrefix("dbd", "http://dbpedia.org/datatype/");
        queryStr.setNsPrefix("dbp", "http://dbpedia.org/property/");
        queryStr.setNsPrefix("dbt", "http://dbpedia.org/resource/Template:");
        queryStr.setNsPrefix("dct", "http://purl.org/dc/terms/");
        queryStr.setNsPrefix("dc", "http://purl.org/dc/elements/1.1/");
        queryStr.setNsPrefix("yago", "http://dbpedia.org/class/yago/");
        queryStr.append(text);
        return queryStr;
    }

    public ParameterizedSparqlString getQuery(int d) {
        ParameterizedSparqlString queryStr = new ParameterizedSparqlString();
        queryStr.setNsPrefix("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        queryStr.setNsPrefix("rdfs", "http://www.w3.org/2000/01/rdf-schema#");
        queryStr.setNsPrefix("dbo", "http://dbpedia.org/ontology/");
        queryStr.setNsPrefix("dbr", "http://dbpedia.org/resource/");
        queryStr.setNsPrefix("dbc", "http://dbpedia.org/resource/Category:");
        queryStr.setNsPrefix("dbd", "http://dbpedia.org/datatype/");
        queryStr.setNsPrefix("dbp", "http://dbpedia.org/property/");
        queryStr.setNsPrefix("dbt", "http://dbpedia.org/resource/Template:");
        queryStr.setNsPrefix("dct", "http://purl.org/dc/terms/");
        queryStr.setNsPrefix("dc", "http://purl.org/dc/elements/1.1/");
        queryStr.setNsPrefix("yago", "http://dbpedia.org/class/yago/");
        String[] text = new String[100];
        text[0] = "select distinct ?p ?abstract ?thumb\n" +
                "where {\n" +
                "       {{?p rdf:type dbo:Cave.} UNION {?p rdf:type dbo:NaturalPlace.}}\n" +
                "       {{?p dbo:location dbr:Vietnam.} UNION {?p dbo:country dbr:Vietnam.}}\n" +
                "       ?p rdfs:comment ?abstract.\n" +
                "       ?p dbo:thumbnail ?thumb\n" +
                "       FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "}\n" +
                "LIMIT 100";
        text[1] = "\n" +
                "\n" +
                "select distinct ?p ?abstract ?thumb\n" +
                "where {\n" +
                "       {{?p rdf:type dbo:Food.} UNION  {?p rdf:type yago:WikicatFermentedFoods.}}\n" +
                "       {{?p dbo:location dbr:Vietnam.} UNION {?p dbo:country dbr:Vietnam.}}\n" +
                "       ?p rdfs:comment ?abstract.\n" +
                "       ?p dbo:thumbnail ?thumb\n" +
                "       FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "}\n" +
                "LIMIT 100";
        text[2] = "\n" +
                "\n" +
                "select distinct ?p ?abstract ?thumb\n" +
                "where {\n" +
                "       {?p dct:subject dbc:Festivals_in_Vietnam.}\n" +
                "       ?p rdfs:comment ?abstract.\n" +
                "       ?p dbo:thumbnail ?thumb\n" +
                "       FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "}\n" +
                "LIMIT 100";
        text[3] = "select distinct ?p ?abstract ?thumb\n" +
                "                where {\n" +
                "                       {  {?p rdf:type yago:WikicatCitiesInVietnam.} UNION {?p rdf:type dbo:Location}}\n" +
                "                     {{?p dbo:location dbr:Vietnam.} UNION {?p dbo:country dbr:Vietnam.}}\n" +
                "                      ?p rdfs:comment ?abstract.                \n" +
                "       ?p dbo:thumbnail ?thumb\n" +
                "                       FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "                }\n" +
                "                LIMIT 100";
        text[4] = "select distinct ?p ?abstract ?thumb\n" +
                "                where {\n" +
                "                       {{?p  dbo:industry dbr:Airline.} UNION  {?p rdf:type yago:WikicatAirlinesOfVietnam.}}\n" +
                "                     {?p dct:subject dbc:Vietnamese_brands.}\n" +
                "?p rdfs:comment ?abstract.                \n" +
                "       ?p dbo:thumbnail ?thumb\n" +
                "                       FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "}";
        text[5] = "select distinct ?p ?abstract ?thumb\n" +
                "                where {\n" +
                "                       {?p rdf:type yago:WikicatEthnicGroupsInVietnam.} \n" +
                "                      ?p rdfs:comment ?abstract.                \n" +
                "       ?p dbo:thumbnail ?thumb\n" +
                "                       FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "                }";
        text[6] = "select distinct ?p ?abstract ?thumb\n" +
                "                where {\n" +
                "                       {?p dct:subject dbc:Lakes_of_Vietnam.} {?p rdf:type dbo:Lake.}\n" +
                "\n" +
                "                      ?p rdfs:comment ?abstract.                \n" +
                "       ?p dbo:thumbnail ?thumb\n" +
                "                       FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "                }";
        //heritage sites
        text[7] = "select distinct ?p ?abstract ?thumb\n" +
                "                where {\n" +
                "                       {?p dct:subject dbc:World_Heritage_Sites_in_Vietnam.}\n" +
                " {?p rdf:type dbo:Place.}\n" +
                " ?p rdfs:comment ?abstract.                \n" +
                "       ?p dbo:thumbnail ?thumb\n" +
                "                       FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "}";
        //touristacommodation
        text[8] = "select distinct ?p ?abstract ?thumb\n" +
                "                where {\n" +
                "                    \n" +
                " {{?p dct:subject dbc:Tourist_accommodations} UNION {?p dct:subject dbc:Hotel_types.}}\n" +
                "?p rdfs:comment ?abstract.                \n" +
                "       ?p dbo:thumbnail ?thumb\n" +
                "                       FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "                \n" +
                "}";
        //dynasty
        text[9] = "select distinct ?p ?abstract ?thumb \n" +
                "\n" +
                "                where { \n" +
                "\n" +
                "                       {?p dct:subject dbc:Vietnamese_dynasties.} {?p rdf:type dbo:Country} \n" +
                "\n" +
                "                       ?p rdfs:comment ?abstract.                 \n" +
                "\n" +
                "       ?p dbo:thumbnail ?thumb \n" +
                "\n" +
                "                       FILTER ( LANG ( ?abstract ) = 'en' ) \n" +
                "\n" +
                "                } ";
        //Airport
        text[10] = "select distinct ?p ?abstract ?thumb\n" +
                "where {\n" +
                "{?p dbo:wikiPageWikiLink dbc:Airports_in_Vietnam}.\n" +
                "{?p rdf:type dbo:Airport}.\n" +
                "       \t?p rdfs:comment ?abstract.\n" +
                "       \t?p dbo:thumbnail ?thumb.\n" +
                "      \t FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "}\n" +
                "LIMIT 100\n";
        //beach
        text[11] = "select distinct ?p ?abstract ?thumb\n" +
                "where {\n" +
                " \t{?p rdf:type yago:WikicatBeachesOfVietnam}.\n" +
                "       \t?p rdfs:comment ?abstract.\n" +
                "       \t?p dbo:thumbnail ?thumb.\n" +
                "     \t FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "}\n";
        //pagoda
        text[12] = "select distinct ?p ?abstract ?thumb\n" +
                "where {\n" +
                "       \t{{?p dct:subject dbc:Temples_in_Vietnam} UNION {?p rdf:type yago:WikicatBuddhistTemples}}.\n" +
                "\t{{?p dbo:wikiPageWikiLink dbc:Temples_in_Vietnam} UNION {?p dbo:wikiPageWikiLink dbr:Vietnam}}.\n" +
                "       \t?p rdfs:comment ?abstract.\n" +
                "       \t?p dbo:thumbnail ?thumb.\n" +
                "      \t FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "}\n" +
                "LIMIT 100\n";
        //moutain
        text[13] = "select distinct ?p ?abstract ?thumb\n" +
                "where {\n" +
                "       {{?p dbo:wikiPageWikiLink dbc:Mountains_of_Vietnam} UNION {?p rdf:type yago:WikicatMountainsOfVietnam}}.\n" +
                "       ?p rdfs:comment ?abstract.\n" +
                "       ?p dbo:thumbnail ?thumb.\n" +
                "       FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "}\n" +
                "LIMIT 100\n";
        //island
        text[14] = "select distinct ?p ?abstract ?thumb\n" +
                "where {    \n" +
                "       \t{{?p rdf:type yago:WikicatIslandsOfVietnam} UNION {?p dbo:wikiPageWikiLink dbc:Archipelagoes_of_Vietnam}}.\n" +
                "        {{?p dct:subject dbc:Archipelagoes_of_Vietnam} UNION {?p dct:subject dbc:Islands_of_Vietnam}}.\n" +
                "      \t?p rdfs:comment ?abstract.\n" +
                "       \t?p dbo:thumbnail ?thumb.\n" +
                "      \tFILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "}\n" +
                "LIMIT 100\n";
        //bridge
        text[15] = "select distinct ?p ?abstract ?thumb\n" +
                "where {\n" +
                "       \t{?p rdf:type dbo:Bridge}.\n" +
                "{?p dbo:wikiPageWikiLink dbr:Vietnam}.\n" +
                "?p rdfs:comment ?abstract.\n" +
                "     \t?p dbo:thumbnail ?thumb.\n" +
                "       FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "}\n" +
                "LIMIT 100\n";
        //structure
        text[16] = "select distinct ?p ?abstract ?thumb\n" +
                "where {\n" +
                "       {{?p rdf:type dbo:Museum} UNION {?p rdf:type dbo:ArchitecturalStructure}}.\n" +
                "       {?p dbo:location dbr:Vietnam}\n" +
                "?p rdfs:comment ?abstract.\n" +
                "       ?p dbo:thumbnail ?thumb.\n" +
                "       FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "}\n" +
                "LIMIT 100\n";
        //river
        text[17] = "select distinct ?p ?abstract ?thumb\n" +
                "where {\n" +
                "       {?p dbo:wikiPageWikiLink dbc:Rivers_of_Vietnam}.\n" +
                "       {?p dbo:wikiPageWikiLink dbr:Vietnam.}\n" +
                "       ?p rdfs:comment ?abstract.\n" +
                "       ?p dbo:thumbnail ?thumb.\n" +
                "       FILTER ( LANG ( ?abstract ) = 'en' )\n" +
                "}\n" +
                "LIMIT 100\n";
        queryStr.append(text[d]);
        return queryStr;
    }
}
