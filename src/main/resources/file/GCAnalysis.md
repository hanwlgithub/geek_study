#GCLogAnalysis
	-XX:+UseConcMarkSweepGC -XX:-UseAdaptiveSizePolicy -Xms512m -Xmx512m -XX:+PrintGCDetails
	
##暂停时间
平均暂停GC时间： 14.9ms
最大暂停GC时间：60.0ms
  
	-XX:+UseConcMarkSweepGC -XX:-UseAdaptiveSizePolicy -Xms1g -Xmx1g -XX:+PrintGCDetails
##暂停时间
平均暂停GC时间： 9.37ms
最大暂停GC时间：50.0ms
  
	-XX:+UseConcMarkSweepGC -XX:-UseAdaptiveSizePolicy -Xms2g -Xmx2g -XX:+PrintGCDetails
##暂停时间
平均暂停GC时间： 19.00ms
最大暂停GC时间：50.0ms
  
	-XX:+UseConcMarkSweepGC -XX:-UseAdaptiveSizePolicy -Xms4g -Xmx4g -XX:+PrintGCDetails
##暂停时间
平均暂停GC时间： 37.00ms
最大暂停GC时间：80.0ms
##结论：
随着内存增大，GC停顿时间会变长

---
####G1GC

 	-XX:+UseG1GC -XX:-UseAdaptiveSizePolicy -Xms512m -Xmx512m -XX:+PrintGCDetails
	
##暂停时间
平均暂停GC时间： 30ms
最大暂停GC时间：30ms
  
	-XX:+UseG1GC -XX:-UseAdaptiveSizePolicy -Xms1g -Xmx1g -XX:+PrintGCDetails
##暂停时间
平均暂停GC时间： 10ms
最大暂停GC时间：10.0ms
  
	-XX:+UseG1GC -XX:-UseAdaptiveSizePolicy -Xms2g -Xmx2g -XX:+PrintGCDetails
##暂停时间
平均暂停GC时间： 10.00ms
最大暂停GC时间：10.0ms
  
	-XX:+UseG1GC -XX:-UseAdaptiveSizePolicy -Xms4g -Xmx4g -XX:+PrintGCDetails
##暂停时间
平均暂停GC时间： 30.00ms
最大暂停GC时间：30.0ms
##结论：
GC 停顿时间跟 内存大小貌似关系不大

---
####UseSerialGC

 	-XX:+UseSerialGC -XX:-UseAdaptiveSizePolicy -Xms512m -Xmx512m -XX:+PrintGCDetails
	
##暂停时间
平均暂停GC时间： 34.4ms
最大暂停GC时间：50ms
  
	-XX:+UseSerialGC -XX:-UseAdaptiveSizePolicy -Xms1g -Xmx1g -XX:+PrintGCDetails
##暂停时间
平均暂停GC时间： 20.9ms
最大暂停GC时间：50.0ms

	-XX:+UseSerialGC -XX:-UseAdaptiveSizePolicy -Xms2g -Xmx2g -XX:+PrintGCDetails
##暂停时间
平均暂停GC时间： 31.6ms
最大暂停GC时间：60.0ms
  
	-XX:+UseSerialGC -XX:-UseAdaptiveSizePolicy -Xms4g -Xmx4g -XX:+PrintGCDetails
##暂停时间
平均暂停GC时间： 62.8ms
最大暂停GC时间：80.0ms
##结论：
随着内存增大，GC停顿时间变长



##总结：当堆内存足够大时，建议采用G1GC垃圾回收器；