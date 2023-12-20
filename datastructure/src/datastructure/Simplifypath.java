package datastructure;

public class Simplifypath {
    public static void main(String[] args) {
        Simplifypath simplifypath = new Simplifypath();
        String s = simplifypath.simplifyPath("/home//foo");
        System.out.println("The simplofy path is "+s);
    }
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        StringBuilder sb = new StringBuilder();
        for(String part : parts){
            if(part.isEmpty() ||part.equals(".")){
                continue;
            }else if(part.equals("..")){
                if(sb.length() > 0){
                    int lastIndex = sb.lastIndexOf("/");
                    sb.delete(lastIndex,sb.length());
                }
            }else{
                sb.append("/").append(part);
            }
        }
        if(sb.length() == 0){
            sb.append("/");
        }

        return sb.toString();
    }
}
