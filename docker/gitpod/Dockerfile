#--------------------------------------------------------------------------------------------------------------
#--------------------------------------------------------------------------------------------------------------
#
# This file contains a custom docker configuration that Gitpod will use for the underlying image for the Gitpod 
# borwser IDE.
#
# For useful context regarding custom Dockerfiles and images for GitPod see these links:
# https://www.gitpod.io/docs/config-docker
# https://www.gitpod.io/blog/docker-in-gitpod
#
#--------------------------------------------------------------------------------------------------------------
#--------------------------------------------------------------------------------------------------------------
FROM gitpod/workspace-full

#--------------------------------------------------------------------------------------------------------------
# Install as root.
#--------------------------------------------------------------------------------------------------------------
USER root


# Install adr-tools -------------------------------------------------------------------------------------------
RUN git clone https://github.com/npryce/adr-tools.git ~/adr-tools \
	&& cd ~/adr-tools && git checkout tags/3.0.0 \
    && echo '' >>  /home/gitpod/.bashrc \
    && echo '' >>  /home/gitpod/.bashrc \
    && echo '###############################################################################' >>  /home/gitpod/.bashrc \
    && echo '##########  adr-tools - systempath - begin' >>  /home/gitpod/.bashrc \
    && echo '###############################################################################' >>  /home/gitpod/.bashrc \
    && echo 'export PATH="$HOME/adr-tools/src:$PATH"' >>  /home/gitpod/.bashrc \
    && echo '###############################################################################' >>  /home/gitpod/.bashrc \
    && echo '##########  adr-tools - systempath - end' >>  /home/gitpod/.bashrc \
    && echo '###############################################################################' >>  /home/gitpod/.bashrc \
    && echo '' >>  /home/gitpod/.bashrc \
    && echo '' >>  /home/gitpod/.bashrc 

# Install git-chglog ------------------------------------------------------------------------------------------
RUN git clone https://github.com/git-chglog/git-chglog.git ~/.git-chglog \
    && cd ~/.git-chglog \
    && make build \
    && install git-chglog /usr/bin
