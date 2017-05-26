# jaxb-parenting
Adds DOM-like support to your JAXB classes by providing default abstract classes

* Version 1.0.0 should be used for java 6 and 7
* Version 2.0.0 requires java 8, fixes java 8 sort function

Supported collection-like functions:
* all java list functions

Supported DOM-like functions:
* copy()
* detach()
* getParent()

# Example

Parent/Child class

```java
@XmlRootElement(name = "americanParent")
public class AmericanParent 
    extends AbstractParent<AmericanChild,AmericanParent> 
    implements AmericanChild {
    
    private String parentName;
    
    public String getParentName(){
        return parentName;
    }
    
    public void setParentName(String parentName){
        this.parentName=parentName;
    }

    @Override
    public AmericanParent copy() {        
        AmericanParent americanParent=(AmericanParent) super.shallowCopy();
        americanParent.setParentName(parentName);
        return americanParent;
      }

    private List<AmericanChild> getChildList(){
        return this;
    }

    @XmlElements({
    @XmlElement(name = "northAmerican", type = NorthAmericanChild.class),
    @XmlElement(name = "southAmerican", type = SouthAmericanChild.class),
    @XmlElement(name = "americanParent", type = AmericanParent.class),
    })
    private void setChildList(List<AmericanChild> childList){
        //copy is needed for java before version 8
        List<AmericanChild> children=new ArrayList<>(childList);
        this.clear();
        this.addAll(children);
    }
}
```

Other children classes

```java
public interface AmericanChild extends Child<AmericanParent> {
    AmericanChild copy();
}

@XmlRootElement(name = "northAmerican")
public class NorthAmericanChild 
    extends AbstractChild<AmericanParent>
    implements AmericanChild {

    public NorthAmericanChild copy() {
      return new NorthAmericanChild();
    }
}

@XmlRootElement(name = "southAmerican")
public class SouthAmericanChild 
    extends AbstractChild<AmericanParent>
    implements AmericanChild {

    public SouthAmericanChild copy() {
        return new SouthAmericanChild();
    }
}
```

All samples can be found in the test folder

Remarque: AbstractChild class cannot be used for AbstractParent classes, as Java doesn't support multiple heritance.

# Packaged child

If you want to have parents with any child from your package.
1. Copy the classes AbstractPackageChild, AbstractPackageParent and interfaces PackageChild, PackageParent to your own package
2. implement in every child/parent these classes

A sample can be found in the test folder (org.speedy.parenting.packaged).