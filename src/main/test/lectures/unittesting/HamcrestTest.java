package lectures.unittesting;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.describedAs;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Test;

public class HamcrestTest {
	
	// Feels very esoteric and not for typical usage used to override the
	// description
	@Test
	public void describedAsExample() throws Exception {
		Matcher<?> matcher = describedAs("My Description", anything());
		Description description = new StringDescription()
				.appendDescriptionOf(matcher);
		assertThat("My Description", is(description.toString()));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void anyOfExampleReturnsTrueIfOneMatches() throws Exception {
		assertThat(
				"Hello",
				is(anyOf(nullValue(), instanceOf(String.class),
						equalTo("Goodbye"))));
	}
	
	@Test
	public void sameInstanceExample() throws Exception {
		Object object = new Object();
		Object sameObject = object;
		assertThat(object, is(sameInstance(sameObject)));
	}

}
