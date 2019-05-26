//package service.audit;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//
//import java.sql.Timestamp;
//
//@Aspect
//public class Audit {
//    /*@Before("execution(* service.repositories.EventRepositoryImpl.putAll(..))")
//    public void before(JoinPoint joinPoint) {
//
//        System.out.println("Ana are mere");
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//
//
//        /*try {
//            FileWriter outputfile = new FileWriter(file, true);
//
//            CSVWriter writer = new CSVWriter(outputfile);
//
//            String message = "Method " + audit.methodName() + " from class " + audit.className() + " was called.";
//            String[] messageToCSV = {timestamp.toString(), message};
//            System.out.println(timestamp.toString());
//
//            writer.writeNext(messageToCSV);
//
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }*/
//    //}
//
//    @Before("execution(* service.repositories.AccountRepositoryImpl.put(..))")
//	public void logBefore(JoinPoint joinPoint) {
//
//    	System.out.println("logBefore() is running!");
//		System.out.println("hijacked : " + joinPoint.getSignature().getName());
//		System.out.println("******");
//	}
//}
