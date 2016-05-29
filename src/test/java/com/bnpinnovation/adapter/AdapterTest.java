package com.bnpinnovation.adapter;

import com.bnpinnovation.DemoApplication;
import com.bnpinnovation.adapter.classadapter.ObjectIterator;
import com.bnpinnovation.adapter.objectadapter.WrappedObjectIterator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@Slf4j
public class AdapterTest {
	private ObjectIterator classAdapter;
	private WrappedObjectIterator objectAdapter;

	@Before
	public void setup() throws IOException {
        String s = "Hello World";
        byte[] b = {'e', 'x', 'a', 'm', 'p', 'l', 'e'};

        // create a new file with an ObjectOutputStream
        FileOutputStream out = new FileOutputStream("test.txt");
        ObjectOutputStream oout = new ObjectOutputStream(out);

        // write something in the file
        oout.writeObject(s);
        oout.writeObject(b);
        oout.flush();

		classAdapter = new ObjectIterator(new FileInputStream("test.txt"));
		objectAdapter = new WrappedObjectIterator(new ObjectInputStream( new FileInputStream("test.txt")));
	}

	@Test
	public void classAdapterTest() {
		while(classAdapter.hasNext()) {
			log.info("class adapter {}", classAdapter.next());
		}
	}

    @Test
    public void objectAdapterTest() {
        while(objectAdapter.hasNext()) {
            log.info("object adapter {}", objectAdapter.next());
        }
    }

}
