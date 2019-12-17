package 练习.栈;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unchecked")
public class _341_扁平化嵌套列表迭代器 {

    public class NestedIterator implements Iterator<Integer> {

        List<Integer> arrayList;
        int index=-1;

        public NestedIterator(List<NestedInteger> nestedList) {
            arrayList=toList(nestedList);
        }

        private List<Integer> toList(List<NestedInteger> nestedIntegerList){
            ArrayList<Integer> list=new ArrayList<>(nestedIntegerList.size());
            for (NestedInteger nestedInteger:nestedIntegerList){
                if (nestedInteger.isInteger()){
                    list.add(nestedInteger.getInteger());
                }else{
                    list.addAll(toList(nestedInteger.getList()));
                }
            }
            return list;

        }

        @Override
        public Integer next() {
            if (this.hasNext())  return arrayList.get(++index);
            return null;
        }

        @Override
        public boolean hasNext() {
            if (index + 1 < arrayList.size()) return true;
            return false;
        }
    }

    public interface NestedInteger {


        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();

    }




}
