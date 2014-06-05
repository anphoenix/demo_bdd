package com.kinisoftware.bdd.jbehave.tasks;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by stefanie on 6/5/14.
 */
@RunWith(AnnotatedEmbedderRunner.class)
@Configure(storyLoader = TaskStories.StoryLoader.class,
        storyReporterBuilder = TaskStories.ReportBuilder.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = false,
        ignoreFailureInView = true, verboseFailures = true)
@UsingSteps(instances = { AddTasksSteps.class, RemoveTasksSteps.class})
public class TaskStories extends InjectableEmbedder {

    @Test
    public void run() throws Exception {
        List<String> storyPaths = new StoryFinder().findPaths(this.getClass().getResource("/"), "**/*.story", "");
        injectedEmbedder().runStoriesAsPaths(storyPaths);
    }

    public static class StoryLoader extends LoadFromClasspath {

        public StoryLoader() {
            super(TaskStories.class.getClassLoader());
        }
    }

    public static class ReportBuilder extends StoryReporterBuilder {

        public ReportBuilder() {
            this.withFormats(org.jbehave.core.reporters.Format.CONSOLE,
                    org.jbehave.core.reporters.Format.HTML).withDefaultFormats();
        }
    }
}
