
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Size result = null;
		
		System.out.println("---- Test 1: 240 * 320 -> 1080 * 1920 ----");
		result = getScaledSize(new Size(240, 320), new Size(1080,1920));
		System.out.println("Result: " + result.toString() + "\n");
		
		System.out.println("---- Test 2: 1280 * 1706 -> 1080 * 1920 ----");
		result = getScaledSize(new Size(1280, 1706), new Size(1080,1920));
		System.out.println("Result: " + result.toString() + "\n");
		
		System.out.println("---- Test 3: 720 * 1280 -> 1080 * 1800 ----");
		result = getScaledSize(new Size(720, 1280), new Size(1080,1800));
		System.out.println("Result: " + result.toString() + "\n");
		
		System.out.println("---- Test 4: 720 * 1280 -> 1080 * 2000 ----");
		result = getScaledSize(new Size(720, 1280), new Size(1080,2000));
		System.out.println("Result: " + result.toString() + "\n");
		
		System.out.println("---- Test 5: 720 * 720 -> 1080 * 2000 ----");
		result = getScaledSize(new Size(720, 720), new Size(1280,2000));
		System.out.println("Result: " + result.toString() + "\n");
	}

	public static Size getScaledSize(Size source, Size target) {
		float sourceRatio = (float)source.getWidth() / source.getHeight();
		float targetRatio = (float)target.getWidth() / target.getHeight();
		boolean baseOnLargerDiff = sourceRatio < targetRatio;

		System.out.println("sourceRatio: " + sourceRatio);
		System.out.println("targetRatio: " + targetRatio);
		System.out.println("baseOnLargerDiff: " + baseOnLargerDiff);

		int widthDiff = source.getWidth() - target.getWidth();
		int heightDiff = source.getHeight() - target.getHeight();
		System.out.println("diff: w = " + widthDiff + ", h = " + heightDiff);

		if (baseOnLargerDiff && widthDiff > heightDiff || !baseOnLargerDiff && widthDiff < heightDiff) {
			System.out.println("width based");
			return new Size(
					target.getWidth(), 
					(int)Math.ceil((float)target.getWidth() / source.getWidth() * source.getHeight()));
		} else {
			System.out.println("height based");
			return new Size(
					(int)Math.ceil((float)target.getHeight() / source.getHeight() * source.getWidth()), 
					target.getHeight());
		}

	}

	private static class Size {
		private int width, height;

		public Size(int width, int height) {
			this.width = width;
			this.height = height;
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}

		@Override
		public String toString() {
			return width + "x" + height;
		}
	}
}
