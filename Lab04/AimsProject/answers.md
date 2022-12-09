1.	When overriding the equals() method of the Object class, you will have to cast the Object parameter 1 to the type of object that you are dealing with. For example, in the Media class, you must cast the Object obj to a Media, and then check the equality of the two objects’ attributes as the above requirements (i.e. title for Media; title and length for Track). If the passing object is not an instance of Media, what happens?
- Nếu ta truyền một Object mà không phải là một thể hiện của Media thì sẽ xuất hiện lỗi runtime error khi cast Object về Media

               2.  What class should implement the Comparable interface?
	        - Lớp Media và Track
3.  In those classes, how should you implement the compareTo() method be to reflect the ordering that we want?
public abstract class Media implements Comparable<Media>{
...
@Override
// Compare cost first, then title
public int compareTo(Media media) {
    return Comparator.comparing(Media::getCost)
            .thenComparing(Media::getTitle)
            .compare(this, media);
}
}

public abstract class Media implements Comparable<Track>{
		...
@Override
// Compare title first, then length
public int compareTo(Track track) {
    return Comparator.comparing(Track::getTitle)
            .thenComparing(Track::getLength)
            .compare(this, media);
}
}
4. Can we have two ordering rules of the item (by title then cost and by cost then title) if we use this Comparable interface approach?
- Chúng ta không thể tạo ra hai quy luật sắp xếp thứ tự của đối tượng khi mà chúng ta sử dụng lớp trừu tượng Comparable . Vì một hàm compareTo() chỉ có thể tạo ra một quy luật.
5. Suppose the DVDs has a different ordering rule from the other media types, that is by title, then decreasing length, then cost. How would you modify your code to allow this?
	Chúng ta có thể nạp chông phương thức compareTo trong lớp Media như sau:
	@Override
public int compareTo(Media media) {
    DigitalVideoDisc dvd = (DigitalVideoDisc) media;
    return Comparator.comparing(DigitalVideoDisc::getTitle)
            .thenComparing(DigitalVideoDisc::getLength, Comparator.reverseOrder())
            .thenComparing(DigitalVideoDisc::getCost)
            .compare(this, dvd);
}

	
