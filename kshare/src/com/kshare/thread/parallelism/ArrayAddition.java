package com.kshare.thread.parallelism;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArrayAddition {
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9
				,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9};
		Object lock = new Object();
		int offset = 0 ;
		int CHUNK_NUBER = 4;
		int CHUNK_SIZE = arr.length/CHUNK_NUBER;
		Thread t1 = new Thread(new ValuePersister(arr, offset, CHUNK_NUBER, lock),"Thread-A");
		offset = offset + CHUNK_SIZE;
		Thread t2 = new Thread(new ValuePersister(arr, offset, CHUNK_NUBER,lock),"Thread-B");
		offset = offset + CHUNK_SIZE;
		Thread t3 = new Thread(new ValuePersister(arr, offset, CHUNK_NUBER,lock),"Thread-C");
		offset = offset + CHUNK_SIZE;
		Thread t4 = new Thread(new ValuePersister(arr, offset, CHUNK_NUBER,lock),"Thread-D");
		System.out.println("Started!");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed!");
	}
}

class ValuePersister implements Runnable{
 int arr[] ;
 int offset;
 int chunckSize;
 int startPos = 0;
 int endPos = 0;
 Object lock ; 

	public ValuePersister(int[] arr, int offset, int chunckSize, Object lock) {
	super();
	this.arr = arr;
	this.offset = offset;
	this.chunckSize = chunckSize;
	this.lock = lock;
	init(this.arr,offset,chunckSize);
}
	private void init(int []a, int offset, int chunksize){
		 startPos = offset;
		 endPos = offset + (int) (this.arr.length/chunckSize) ;	
	}


	@Override
	public void run() {
			Connection con = null;
			PreparedStatement ps = null;
			int sum = 0 ;
			try {
				con = ConnectionDispenser.getConnection();
				con.setAutoCommit(false);
				System.out.println(con.toString());
				for(int i = startPos ; i <= endPos-1 ; i++){
					sum  = sum + arr[i];
				}
				String sql = "insert into ArrayData values (?,?)";
				ps = con.prepareStatement(sql);
				System.out.println(Thread.currentThread().getName());

				ps.setString(1,Thread.currentThread().getName());
				ps.setInt(2, sum);
				if(Thread.currentThread().getName().equals("Thread-B")){
					throw new SQLException("This is envader thread!");
				}	
				ps.execute();

				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}finally {
				try {
/*					if(ps != null){
						ps.close();
					}
					if(con != null){
						con.close();
					}*/
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}

		}
	}
	

 class ConnectionDispenser {
    static String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    static Connection con = null;

    private static ThreadLocal<Connection> connectionHolder
            = new ThreadLocal<Connection>() {
                public Connection initialValue() {
                    try {
                        return DriverManager.getConnection(DB_URL, "root", "root");
                    } catch (SQLException e) {
                        throw new RuntimeException("Unable to acquire Connection, e");
                    }
                };
            };

    public static Connection getConnection() {
        return connectionHolder.get();
    }
/*    public static synchronized Connection  getConnection() throws SQLException {
    	if(con ==null){
    		con = DriverManager.getConnection(DB_URL, "root", "root");
    	}
        return con;
    } */
    
}
