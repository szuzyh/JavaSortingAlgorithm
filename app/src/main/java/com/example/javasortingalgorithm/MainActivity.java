package com.example.javasortingalgorithm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    public int[] data={22,15,32,11,12,13,56,46,8,45,97,12};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        直接插入排序
//        int temp=0;
//        for (int i=0;i<data.length;i++){
//            int j=i-1;
//            temp=data[i];
//            for (;j>=0&&temp<data[j];j--){
//                data[j+1]=data[j];
//                    System.out.println("Once: "+j+"   "+data[j]);
//            }
//            data[j+1]=temp;
//                System.out.println("Twice: "+i+ "    "+data[i]);
//        }
//        希尔排序
//        double d1=data.length;
//        int temp;
//        while (true){
//            d1=Math.ceil(d1/2);
//           int d = (int) d1;
//            for (int i=0;i<=d;i++){
//                for (int x=i+d;x<data.length;x+=d){
//                    int j=x-d;
//                    temp=data[x];
//                    for (;j>=0&&temp<data[j];j-=d){
//                        data[j+d]=data[j];
//                    }
//                    data[j+d]=temp;
//                }
//            }
//            if (d==1){
//                break;
//            }
//
//        }
//        for (int k=0;k<data.length;k++){
//            System.out.println(data[k]);
//        }


        //简单选择排序

//        int position; //记录最小值的下标
//        int temp;  //记录最小值的值，一开始是data[i],后来在j的循环里不断被最小值替代
//        for (int i=0;i<data.length;i++){
//            position=i;
//            temp=data[i];
//            int j=i+1;
//            for (;j<data.length;j++){
//                if (data[j]<temp){
//                    temp=data[j];
//                    position=j;
//                }
//            }
//            data[position]=data[i];
//            data[i]=temp;
//        }
//        for (int k=0;k<data.length;k++){
//            System.out.println(data[k]);
//        }
//


        //堆排序
     // heapsort(data);
        //冒泡排序
//        int temp;
//        for (int i=0;i<data.length-1;i++){
//            for (int j=0;j<data.length-1-i;j++){
//                if (data[j]>data[j+1]){
//                    temp=data[j];
//                    data[j]=data[j+1];
//                    data[j+1]=temp;
//                }
//            }
//        }
//
//        for (int k=0;k<data.length;k++){
//            System.out.println(data[k]);
//        }

        //快速选择排序
           // quick(data);
//        for (int k=0;k<data.length;k++){
//            System.out.println(data[k]);
//        }
        //归并排序
        sort(data,0,data.length-1);
        for (int k=0;k<data.length;k++){
            System.out.println(data[k]);
        }
    }

    private void sort(int[] data, int left, int right) {
        if (left<right){
            int center=(left+right)/2;
            sort(data,left,center);
            sort(data,center+1,right);
            //合并
            merge(data,left,center,right);
        }
    }

    private void merge(int[] data, int left, int center, int right) {
        int[] tempArr=new int[data.length];
        int mid=center+1; //j
        int third=left;  //i
        int temp=left;   //k
        while (third<=center&&mid<=right){
            if (data[third]<=data[mid]){
                tempArr[temp]=data[third];
                third++;
            }else {
                tempArr[temp]=data[mid];
                mid++;
            }
        }

       if (third>center){
           for (int t=mid;t<=right;t++){
               tempArr[temp+t+mid]=data[t];
           }
       }else {
           for (int t=third;t<=center;t++){
               tempArr[temp+t+mid]=data[t];
           }
       }
        System.out.println(Arrays.toString(data));

    }

//    private void quick(int[] data) {
//        if (data.length>0){
//            quickSort(data,0,data.length-1);
//        }
//    }
//
//    private void quickSort(int[] list, int low, int high) {
//        if (low<high){
//            int middle=getMiddle(list,low,high);
//            quickSort(list,low,middle-1);
//            quickSort(list,middle+1,high);
//
//        }
//
//    }
//
//    private int getMiddle(int[] list, int low, int high) {
//        int temp=list[low];
//        while (low<high) {
//            while (low < high && list[high] >= temp) {
//                high--;//得到从右边算起第一个小于基准元素的数据的下标
//            }
//            list[low] = list[high];  //进行交换
//            while (low < high && list[low] <= temp) {
//                low++;//得到从左边算起第一个大于基准元素的数据的下标
//            }
//            list[high]=list[low]; //交换
//        }
//        //最后low = high 即low high 同时都表示中轴,若出现low=high-1,因为最后变化的是low 所以中轴为low
//        list[low]=temp;  //基准元素在中轴位置
//        return low;   //返回中轴
//    }

//    private void heapsort(int[] data) {
//        System.out.println("开始排序");
//        int arrayLength=data.length;
//        //循环建堆
//        for (int i=0;i<arrayLength-1;i++){
//           //开始建堆
//            buildMaxHeap(data,arrayLength-1-i);
//            swap(data,0,arrayLength-1-i);  //引入i 变量，是因为每次循环都确定一个结点的值，因此需要过滤掉那个结点
//            System.out.println(Arrays.toString(data));
//        }
//    }
//
//    private void swap(int[] data, int i, int j) {
//        int temp=data[i];
//        data[i]=data[j];
//        data[j]=temp;
//    }
//
//    private void buildMaxHeap(int[] data, int lastIndex) {
//        for (int i=(lastIndex-1)/2;i>=0;i--){
//            int k=i;   //父节点下标
//            while (k*2+1<=lastIndex){  //当变化的树层不是倒数第一二层时，会引起下面层的变化，
//                                         //这个判断正是为了继续建堆
//                int biggerIndex=2*k+1;   //此时为左儿子下标，但这个变量是为了存储左右儿子最大值而存在
//                if (biggerIndex<lastIndex){  //说明右儿子存在
//                    if (data[biggerIndex]<data[biggerIndex+1]){
//                        biggerIndex++;//取得左右儿子最大值的下标
//                    }
//                }
//                if (data[k]<data[biggerIndex]){
//                    swap(data,k,biggerIndex);
//                    k=biggerIndex; //从这里改变k值，看看会不会继续往下变化
//                }else {
//                    break;
//                }
//            }
//        }
//    }

}
