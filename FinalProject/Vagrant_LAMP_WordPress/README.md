Vagrant LAMP with Wordpress
===========================

Want to test a new web app but don't want to affect your current Apache / MySQL / PHP system?
Applications like MAMP are great, but they don't make it easy to maintain multiple, separate
web roots.

If you find yourself needing quick to configure web stack, but also one that is customizable try this Vagrant project

Vagrant allows for Virtual Machines to be quickly setup, and easy to use.

And this project aims to make it very easy to spinup a complete LAMP stack in a matter of minutes.

It also installs the latest version of Wordpress into `/var/www/html` and
points it at a new MySQL database.

Requirements
------------
* VirtualBox <http://www.virtualbox.com>
* Vagrant <http://www.vagrantup.com>
* Git <http://git-scm.com/>

Usage
-----

#### Wordpress

The Wordpress instance (running on Apache) is available at [http://localhost:8888](http://localhost:8888)

You should see the Wordpress install wizard and if all went well, it should
already be communicating with the database thanks to the config installed at
`/var/www/html/wp-config.php`

#### MySQL
Externally the MySQL server is available at port 8889, and when running on the VM it is available as a socket or at port 3306 as usual.
Username: root
Password: root

#### Database import
If you want to import existing database, file to import can be set in `provision.sh` in `wordpress_database_dumped` variable. By default, it's `wordpress.dump.sql`

Technical Details
-----------------
* Ubuntu 14.04 64-bit
* Apache 2
* PHP 5.5
* MySQL 5.5

We are using the base Ubuntu 14.04 box from Vagrant. If you don't already have it downloaded
the Vagrantfile has been configured to do it for you. This only has to be done once
for each account on your host computer.

The web root is located in the project directory at `src/` and you can install your files there

And like any other vagrant file you have SSH access with

	$ vagrant ssh
