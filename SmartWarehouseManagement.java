import java.util.ArrayList;

abstract class WarehouseItem
{
	private String name;
	private int id;
	
	public WarehouseItem(String name,int id)
	{
		this.name=name;
		this.id=id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int  getid()
	{
		return id;
	}
	
	abstract void display();
}

class Electronics extends WarehouseItem
{
	private String packingType;
	
	public Electronics(String name,int id,String packingType)
	{
		super(name,id);
		this.packingType=packingType;
	}
	
	public void display()
	{
		System.out.println("name:"+super.getName());
		System.out.println("id:"+super.getid());
		System.out.println("packingType:"+packingType);
	}
}

class Groceries extends WarehouseItem
{
	private String location;
	private int duration;
	
	public Groceries(String name,int id,String location,int duration)
	{
		super(name,id);
		this.location=location;
		this.duration=duration;
		
	}
	
	public void display()
	{
		System.out.println("name:"+super.getName());
		System.out.println("id:"+super.getid());
		System.out.println("location:"+location);
		System.out.println("duration:"+duration);
	}
	
}

class Furniture extends WarehouseItem
{
	private String type;
	private int noOfseats;
	
	public Furniture(String name,int id,String type,int noOfseats)
	{
		super(name,id);
		this.type=type;
		this.noOfseats=noOfseats;
	}
	
	public void display()
	{
		System.out.println("name:"+super.getName());
		System.out.println("id:"+super.getid());
		System.out.println("type:"+type);
		System.out.println("noOfseats:"+noOfseats);
	}
}

class Storage<T extends WarehouseItem>
{ 
	
	
	public void add(T item,ArrayList <T> items )
	{
		items.add(item);
	}
	
	public void display(ArrayList<? extends WarehouseItem> items)
	{
		for(WarehouseItem i: items)
		{
			i.display();
		}
	}
	
	
}

public class  SmartWarehouseManagement
{
	public static void main(String[] args)
	{
	
		Electronics e=new Electronics("mobile",1,"bubble wrap");
		Groceries g=new Groceries("curd",2,"freezer",3);
		Furniture f=new Furniture("sofa",3,"seater",5);
		ArrayList<WarehouseItem> items=new ArrayList <>();
		Storage<WarehouseItem> s=new Storage<>();
		s.add(e,items);
		s.add(g,items);
		s.add(f,items);
		s.display(items);
	}
}