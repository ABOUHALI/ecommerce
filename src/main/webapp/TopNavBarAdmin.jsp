<nav
	class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
	<div
		class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
		<a class="navbar-brand brand-logo" href="index.html"> <img
			src="assets/images/logo.svg" alt="logo" />
		</a> <a class="navbar-brand brand-logo-mini" href="index.html"> <img
			src="assets/images/logo-mini.svg" alt="logo" />
		</a>
	</div>
	<div class="navbar-menu-wrapper d-flex align-items-center">

		<ul class="navbar-nav ml-auto">
			
			<li class="nav-item dropdown d-none d-xl-inline-block user-dropdown">
				<a class="nav-link dropdown-toggle" id="UserDropdown" href="#logout"
				data-toggle="dropdown" aria-expanded="false"> <img
					class="img-xs rounded-circle" src="assets/images/faces/face8.jpg"
					alt="Profile image">
			</a>
				<div class="dropdown-menu dropdown-menu-right navbar-dropdown" id="logout"
					aria-labelledby="UserDropdown">
					<div class="dropdown-header text-center">
						<img class="img-md rounded-circle"
							src="assets/images/faces/face8.jpg" alt="Profile image">
						<p class="mb-1 mt-3 font-weight-semibold">${ admin.getLogin() }</p>
					</div>
					 <a
						class="dropdown-item" href="logout">Sign Out<i
						class="dropdown-item-icon ti-power-off"></i></a>

				</div>
			</li>
		</ul>
		<button
			class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
			type="button" data-toggle="offcanvas">
			<span class="mdi mdi-menu"></span>
		</button>
	</div>
</nav>