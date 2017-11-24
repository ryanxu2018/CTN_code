/*import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.RowLayout;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import swing2swt.layout.BoxLayout;
import org.eclipse.wb.swt.SWTResourceManager;

public class Main_gui {

	/**
	 * Launch the application.
	 * @param args
	 

		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		//set up the menu bar
	    Menu menuBar = new Menu(shell, SWT.BAR);
	    MenuItem cascadeFileMenu = new MenuItem(menuBar, SWT.CASCADE);
	    cascadeFileMenu.setText("&File");
	    Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
	    cascadeFileMenu.setMenu(fileMenu);
	    MenuItem openItem = new MenuItem(fileMenu,SWT.PUSH) ;
	    MenuItem exitItem = new MenuItem(fileMenu, SWT.PUSH);
	    MenuItem saveItem = new MenuItem(fileMenu, SWT.PUSH);
	    openItem.setText("&New\tCTRL+0");
	    openItem.setAccelerator(SWT.CTRL + '0');
	    saveItem.setText("&Save\tCTRL+0");
	    saveItem.setAccelerator(SWT.CTRL+'S');
	    
	    exitItem.setText("&Exit");
	    shell.setMenuBar(menuBar);
	     exitItem.addListener(SWT.Selection, event-> {
	     shell.getDisplay().dispose();
	           System.exit(0);
	        });
	     
	     
		
		Button btnTest = new Button(shell, SWT.NONE);
		btnTest.setBounds(153, 250, 60, 28);
		btnTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnTest.setText("TEST");
		
		Button btnReset = new Button(shell, SWT.NONE);
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnReset.setGrayed(true);
		btnReset.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		btnReset.setBounds(219, 250, 60, 28);
		btnReset.setText("RESET");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	
	class Open implements SelectionListener {
	      public void widgetSelected(SelectionEvent event) {
	        FileDialog fd = new FileDialog(s, SWT.OPEN);
	        fd.setText("Open");
	        fd.setFilterPath("C:/");
	        String[] filterExt = { "*.txt", "*.doc", ".rtf", "*.*" };
	        fd.setFilterExtensions(filterExt);
	        String selected = fd.open();
	        System.out.println(selected);
	      }
	      public void widgetDefaultSelected(SelectionEvent event) {
	      }
	    }
	public static void main(String[] args) {
		
		new Main_gui();
		
	}

}
*/

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.wb.swt.SWTResourceManager;

public class Main_gui {
  Display d;

  Shell s;

  Main_gui() {
    d = new Display();
    s = new Shell(d,SWT.SHELL_TRIM);
    s.setSize(400, 400);
    
    //setup the image display area 
    Label imageField = new Label(s, SWT.NONE);
    imageField.setBounds(0, 0, 400, 334);
    s.open();
    
    s.setText("A MessageBox Example");
    //         create the menu system
    Menu m = new Menu(s, SWT.BAR);
    // create a file menu and add an exit item
    final MenuItem file = new MenuItem(m, SWT.CASCADE);
    file.setText("&File");
    final Menu filemenu = new Menu(s, SWT.DROP_DOWN);
    file.setMenu(filemenu);
    final MenuItem openItem = new MenuItem(filemenu, SWT.PUSH);
    openItem.setText("&Open\tCTRL+O");
    openItem.setAccelerator(SWT.CTRL + 'O');
    final MenuItem saveItem = new MenuItem(filemenu, SWT.PUSH);
    saveItem.setText("&Save\tCTRL+S");
    saveItem.setAccelerator(SWT.CTRL + 'S');
    final MenuItem separator = new MenuItem(filemenu, SWT.SEPARATOR);
    final MenuItem exitItem = new MenuItem(filemenu, SWT.PUSH);
    exitItem.setText("E&xit");

    class Open implements SelectionListener {
      public void widgetSelected(SelectionEvent event) {
        FileDialog fd = new FileDialog(s, SWT.OPEN);
        fd.setText("Open");
        fd.setFilterPath("C:/");
        String[] filterExt = { "*.txt", "*.doc", ".rtf", "*.*" };
        fd.setFilterExtensions(filterExt);
        String selected = fd.open();
        System.out.println(selected);
        try 
        {
            Image image = new Image(d, selected);
            imageField.setImage(image);
        	}
        catch(Exception e) 
        {
        	 System.out.println(e);
        }
        
      }

      public void widgetDefaultSelected(SelectionEvent event) {
    	      System.out.println("hello");
      }
    }

    class Save implements SelectionListener {
      public void widgetSelected(SelectionEvent event) {
        FileDialog fd = new FileDialog(s, SWT.SAVE);
        fd.setText("Save");
        fd.setFilterPath("C:/");
        String[] filterExt = { "*.txt", "*.doc", ".rtf", "*.*" };
        fd.setFilterExtensions(filterExt);
        String selected = fd.open();
        System.out.println(selected);
      }

      public void widgetDefaultSelected(SelectionEvent event) {
      }
    }
    openItem.addSelectionListener(new Open());
    saveItem.addSelectionListener(new Save());

    exitItem.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
        MessageBox messageBox = new MessageBox(s, SWT.ICON_QUESTION
            | SWT.YES | SWT.NO);
        messageBox.setMessage("Do you really want to exit?");
        messageBox.setText("Exiting Application");
        int response = messageBox.open();
        if (response == SWT.YES)
          System.exit(0);
      }
    });
    s.setMenuBar(m);


    while (!s.isDisposed()) {
      if (!d.readAndDispatch())
        d.sleep();
    }
    d.dispose();
  }

  public static void main(String[] argv) {
    new Main_gui();
  }
}

