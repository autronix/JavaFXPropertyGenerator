#JavaFX Property Generator

## Description
Simple application to generate JavaFX properties, initializations, getters and setters

## Usage
 - compile and run
 - enter class name as the "Title"
 - each property should be formated as follows:
  - propertyname:type
  - separate with semi-colon (";")
  
Supported types:
 - int
 - long
 - double
 - float
 - boolean
 - String
 
## Example

Here is an example of a listing:

```
someInt:int;someLong:long;someFloat:float;someDouble:double;someBoolean:boolean;someString:String
``` 

This is the resulting generated code:
```java
	/***************************************************/
	/*** Parametrized constructor for MyProperties ***/
	public MyProperties( int som0, long som1, float som2, double som3, boolean som4, String som5){
		someIntProperty = new SimpleIntegerProperty(som0);
		someLongProperty = new SimpleLongProperty(som1);
		someFloatProperty = new SimpleFloatProperty(som2);
		someDoubleProperty = new SimpleDoubleProperty(som3);
		someBooleanProperty = new SimpleBooleanProperty(som4);
		someStringProperty = new SimpleStringProperty(som5);

	}

	/*** MyProperties properties  ***/
	private SimpleIntegerProperty someIntProperty;
	private SimpleLongProperty someLongProperty;
	private SimpleFloatProperty someFloatProperty;
	private SimpleDoubleProperty someDoubleProperty;
	private SimpleBooleanProperty someBooleanProperty;
	private SimpleStringProperty someStringProperty;

	/*** Initialize properties ***/
	private void initMyPropertiesProperties(){
		someIntProperty = new SimpleIntegerProperty(0);
		someLongProperty = new SimpleLongProperty(0);
		someFloatProperty = new SimpleFloatProperty(0.00);
		someDoubleProperty = new SimpleDoubleProperty(0.00);
		someBooleanProperty = new SimpleBooleanProperty(false);
		someStringProperty = new SimpleStringProperty("");

	}

	/*** SomeInt property methods  ***/
	public SimpleIntegerProperty someIntProperty(){
		return someIntProperty;
	}

	public int getSomeInt(){
		return someIntProperty.get();
	}

	public void setSomeInt(int v){
		someIntProperty.set(v);
	}

	/*** SomeLong property methods  ***/
	public SimpleLongProperty someLongProperty(){
		return someLongProperty;
	}

	public long getSomeLong(){
		return someLongProperty.get();
	}

	public void setSomeLong(long v){
		someLongProperty.set(v);
	}

	/*** SomeFloat property methods  ***/
	public SimpleFloatProperty someFloatProperty(){
		return someFloatProperty;
	}

	public float getSomeFloat(){
		return someFloatProperty.get();
	}

	public void setSomeFloat(float v){
		someFloatProperty.set(v);
	}

	/*** SomeDouble property methods  ***/
	public SimpleDoubleProperty someDoubleProperty(){
		return someDoubleProperty;
	}

	public double getSomeDouble(){
		return someDoubleProperty.get();
	}

	public void setSomeDouble(double v){
		someDoubleProperty.set(v);
	}

	/*** SomeBoolean property methods  ***/
	public SimpleBooleanProperty someBooleanProperty(){
		return someBooleanProperty;
	}

	public boolean getSomeBoolean(){
		return someBooleanProperty.get();
	}

	public void setSomeBoolean(boolean v){
		someBooleanProperty.set(v);
	}

	/*** SomeString property methods  ***/
	public SimpleStringProperty someStringProperty(){
		return someStringProperty;
	}

	public String getSomeString(){
		return someStringProperty.get();
	}

	public void setSomeString(String v){
		someStringProperty.set(v);
	}

	/***************************************************/
```
