<div class="modal fade" id="userModal" tabindex="-1" aria-labelledby="userModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content p-4">
      <div class="modal-header border-0">
        <h5 class="modal-title fs-3 fw-bold" id="userModalLabel">Sign Up</h5>

        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form>
          <div class="mb-3">
            <label for="fullName" class="form-label">Name</label>
            <input type="text" class="form-control" id="fullName" placeholder="Enter Your Name" required="">
          </div>
          <div class="mb-3">
            <label for="email" class="form-label">Email address</label>
            <input type="email" class="form-control" id="email" placeholder="Enter Email address" required="">
          </div>

          <div class="mb-5">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Enter Password" required="">
            <small class="form-text">By Signup, you agree to our <a href="#!">Terms of Service</a> & <a
                href="#!">Privacy Policy</a></small>
          </div>

          <button type="submit" class="btn btn-primary">Sign Up</button>
        </form>
      </div>
      <div class="modal-footer border-0 justify-content-center">

        Already have an account? <a href="#">Sign in</a>
      </div>
    </div>
  </div>
</div>
