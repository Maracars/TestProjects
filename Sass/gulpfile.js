var gulp = require('gulp');
// Requires the gulp-sass plugin
var sass = require('gulp-sass');

var cleanCSS = require('gulp-clean-css');

var rename = require('gulp-rename');
// Styles
gulp.task('sass', function(){
	return gulp.src('WebContent/scss/*.scss')
	.pipe(sass())
	.pipe(gulp.dest('WebContent/css'))
});

gulp.task('minify', function() {
	return gulp.src(['WebContent/css/*.css', '!WebContent/css/*.min.css'])
	.pipe(cleanCSS())
	.pipe(rename({
		suffix :'.min'
	}))
	.pipe(gulp.dest('WebContent/css/'));
});

gulp.task('watch', function(){
	gulp.watch('WebContent/scss/*.scss', ['sass', 'minify'])
});