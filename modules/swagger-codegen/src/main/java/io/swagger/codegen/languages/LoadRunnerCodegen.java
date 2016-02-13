package io.swagger.codegen.languages;

import io.swagger.codegen.CodegenConfig;
import io.swagger.codegen.CodegenType;
import io.swagger.codegen.DefaultCodegen;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by RaGe-HTPC1 on 2/12/2016.
 */
public class LoadRunnerCodegen extends DefaultCodegen implements CodegenConfig {
    @Override
    public CodegenType getTag() {
        return CodegenType.CLIENT;
    }

    @Override
    public String getName() {
        return "loadrunner";
    }

    @Override
    public String getHelp() {
        return "Generates a LoadRunner .c file.";
    }

    public LoadRunnerCodegen(){
        super();

        // set default output folder
        outputFolder = "generated-code/LoadRunner";

        /**
         * Api classes.  You can write classes for each Api file with the apiTemplateFiles map.
         * as with models, add multiple entries with different extensions for multiple files per
         * class
         */
        apiTemplateFiles.put(
                "script.mustache",   // the template to use
                ".c");               // the extension for each file to write

        /**
         * Template Location.  This is the location which templates will be read from.  The generator
         * will use the resource stream to attempt to read the templates.
         */
        templateDir = "LoadRunner";

        /**
         * Reserved words.  Override this with reserved words specific to your language
         */
        reservedWords = new HashSet<String>(
                Arrays.asList(
                        "sample1",  //TODO use actual LR reserved words
                        "sample2")
        );
    }

    /**
     * Escapes a reserved word as defined in the `reservedWords` array. Handle escaping
     * those terms here.  This logic is only called if a variable matches the reseved words
     *
     * @return the escaped term
     */
    @Override
    public String escapeReservedWord(String name) {
        return "_" + name;  // add an underscore to the name
    }



}
