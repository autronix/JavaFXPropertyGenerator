package com.autronix.getsetgen;

import java.util.Scanner;

public class PropertyGetSetGenerator {

	/*** Templates ****************************************/
	private final static String tplPropertyDeclaration = "\tprivate Simple[TYPE]Property [PROP]Property;\n";
	private final static String tplInitBlock = "\n\t/*** Initialize properties ***/\n\tprivate void init[TITLE]Properties(){\n[CONTENTS]\n\t}\n\n";
	private final static String tplProperyBlock = "\tpublic Simple[TYPE]Property [PROP]Property(){\n\t\treturn [PROP]Property;\n\t}\n";
	private final static String tplGetBlock = "\tpublic [TYPE] get[METHOD](){\n\t\treturn [PROP]Property.get();\n\t}\n";
	private final static String tplSetBlock = "\tpublic void set[METHOD]([TYPE] v){\n\t\t[PROP]Property.set(v);\n\t}\n";
	private final static String tplDeclaration = "\t\t[PROP]Property = new Simple[TYPE]Property([DEFAULT]);\n"; 
	private final static String tplConstructorBlock = "\t/*** Parametrized constructor for [CONSTRUCTOR] ***/\n\tpublic [CONSTRUCTOR]([PARAMS]){\n[CONTENTS]\n\t}\n\n";
	
		
	/*** Templates ****************************************/
	private static String title;
	private static String properties;
	
	
	public static void main(String[] args) {
		
		System.out.println("*****************************************************************");
		System.out.println("* Constructor, Property, Getter and Setter Generator");
		System.out.println("*****************************************************************");
	
		init();
	}
	
	private static void init(){
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a title (CamelCase)> ");
		title = reader.next(); // Scans the next token of the input as an int.
		System.out.println("Enter properties list (property:type;)>");
		properties= reader.next();
		reader.close();
		
		generateDeclaration();
	}
	
	
	private static void generateDeclaration(){
		
		String prop_items[] = properties.split(";");
		
		String type = "";
		String type2 = "";
		String value = "";
		String method = "";
		String prop = "";
		String param = "";
		String param_name = "";
		
		String initContent = "";
		String declarationContent = "\t/*** "+title+" properties  ***/\n";
		String methodPropContent = "";
		String methodGetContent = "";
		String methodSetContent = "";
		String getSetContent = "";
		String initBlock = "";
		
		String paramsBlock = "";
		String paramtrizedDeclarationContent = "";
		String constructorBlock = "";
		
		
		
		String output = "\t/***************************************************/\n";
		
		
		for(int i=0; i< prop_items.length; i++){
			
			String item[] = prop_items[i].split("(:|\n)");
			prop = item[0];
			method = prop.substring(0, 1).toUpperCase() + prop.substring(1);
			
			getSetContent += "\t/*** "+method+" property methods  ***/\n";
			
			if(item[1].equals("int")){
				type = "Integer";
				type2 = "int";
				value = "0";
			}
			else if(item[1].equals("long")){
				type = "Long";
				type2 = "long";
				value = "0"; 
			}
			else if(item[1].equals("float")){
				type = "Float";
				type2 = "float";
				value = "0.00"; 
			}
			else if(item[1].equals("double")){
				type = "Double";
				type2 = "double";
				value = "0.00"; 
			}
			else if(item[1].equals("boolean")){
				type = "Boolean";
				type2 = "boolean";
				value = "false"; 
			}
			else if(item[1].equals("String")){
				type = "String";
				type2 = "String";
				value = "\"\""; 
			}
			
			//Parameter for Params list
			param_name = prop.substring(0, 3)+String.format("%d", i);
			param = " "+type2+" "+param_name+",";
			paramsBlock += param;
			paramtrizedDeclarationContent += tplDeclaration.replaceAll("\\[PROP\\]", prop).replaceAll("\\[TYPE\\]",type).replaceAll("\\[DEFAULT\\]", param_name);
			//tplConstructorBlock
			
			// Simple declaration
			declarationContent += tplPropertyDeclaration.replaceAll("\\[PROP\\]", prop).replaceAll("\\[TYPE\\]",type);
			
			initContent += tplDeclaration.replaceAll("\\[PROP\\]", prop).replaceAll("\\[TYPE\\]",type).replaceAll("\\[DEFAULT\\]", value);
			
			methodPropContent = tplProperyBlock.replaceAll("\\[PROP\\]", prop).replaceAll("\\[TYPE\\]",type).replaceAll("\\[METHOD\\]",method);
			methodGetContent = tplGetBlock.replaceAll("\\[PROP\\]", prop).replaceAll("\\[TYPE\\]",type2).replaceAll("\\[METHOD\\]",method);
			methodSetContent = tplSetBlock.replaceAll("\\[PROP\\]", prop).replaceAll("\\[TYPE\\]",type2).replaceAll("\\[METHOD\\]",method);
			
			getSetContent += methodPropContent + "\n" + methodGetContent + "\n" + methodSetContent + "\n";
			
		}
		
		// Remove comma from last parameter
		paramsBlock = paramsBlock.replaceAll(",$", "");
		
		
		initBlock = tplInitBlock.replaceAll("\\[TITLE\\]", title).replaceAll("\\[CONTENTS\\]",initContent);
		
		constructorBlock = tplConstructorBlock.replaceAll("\\[CONSTRUCTOR\\]", title).replaceAll("\\[CONTENTS\\]",paramtrizedDeclarationContent).replaceAll("\\[PARAMS\\]", paramsBlock);
		
		output += constructorBlock+declarationContent + initBlock + getSetContent; 
		
		
		output += "\t/***************************************************/";
		
		System.out.printf(output);
		
	}

}

