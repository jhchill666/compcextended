################################################################################
#                                                                              #
# README - CompcExtended                                                       #
#                                                                              #
################################################################################

Contents
  I.	Requirements
  II.   Installation
  III.  Using flexTasks
    A.  compcx

###################

  I.     Requirements
  
This version of CompcExtended uses the Adobe Flex 4.6.0.23201 SDK distribution
of Apache ANT.  I cannot therefore support errors when using compcx with other
Flex SDK build versions.  The source is provided in full, so you're welcome to
modify and recompile for any SDK you may require this functionality for. 

  II.    Installation

The CompcExtended task, is an extension of the standard flexTask.jar from Adobe. 
The standard tasks as provided by Adobe are untouched, yet I've added a new task
to the distribution that provides identical functionality to the standard compc
task, but adds ease of use for including arbitary files types in your output
swc.  This task is named compx (CompcExtended).

I won't go into how to install and run flexTasks as you'll probably have a firm
grasp on that if you're reading this anyway!

For a recap please go here:
http://help.adobe.com/en_US/flex/using/WS2db454920e96a9e51e63e3d11c0bf678b2-7ffc.html

#########

  III.   Using flexTasks

#####

    A.  compcx
    
The new compcx task is included and used in an identical fashion as the standard
compc task.  The only difference being that instead of using the 'compc' directive
in your Ant task, use the 'compcx' instead.

The (currently) only difference between compc and compcx, is that the new task
exposes a new property named 'include-files'.  This strives to makes inclusion
of asset files in a distribution swc much more user friendly.

Previously, to include an arbitary set of asset files in the resultant swc, you
had to explicitly add each one, with the 'include-file' compiles argument. This
became not only laborious, but actually unworkable, for distributing assets across
in an enterprise environment.

The following example shows the usage for compc include-file:

<include-file name="an_image.png" value="path/to/image/folder/an_image.png"/>

CompcExtended expands upon this, by essentially providing the user the option,
of declaring a FileSet to add to the resulting swc.  Standard FileSet includes 
and excludes provide further granularity over what is included in the final swc.

The following example shows the usage for include-files property:

<include-files dir="${swc.resources.dir}">
    <include name="**/*.*" />
    <exclude name="**/*.ttf"/>
</include-files>

This will include everything in the specified directory, except true type fonts. 
Similarly includes can be declared inline to streamline the syntax:

<include-files dir="${swc.resources.dir}" include="**/*.png,**/*.jpg,**/*.gif"/>


################################################################################
#                                                                              #
# End of README                                                                #
#                                                                              #
################################################################################
