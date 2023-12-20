package datastructure;

public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        String res = simplifyPath.simplifyPath("/home//foo");
        System.out.println("the simplified path is "+ res);
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
