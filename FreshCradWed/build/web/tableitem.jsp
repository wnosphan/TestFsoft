<!-- table -->

            <div class="table-responsive">
              <table class="table text-nowrap table-with-checkbox">
                <thead class="table-light">
                  <tr>
                 
                    <th>Product</th>
                    <th>Amount</th>
                    <th>Status</th>

                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${listProduct}" var="x">
                      <tr><td class="align-middle">
                                        <div>
                                            <h5 class="fs-6 mb-0"><a href="#" class="text-inherit">${x.product}</a>
                                            </h5>
                                        </div>
                                    </td>
                      
                     <td class="align-middle">$${x.amount}</td>
                     <td class="align-middle"><span class="badge bg-success">${x.status}</span></td>
                     </tr>
                  </c:forEach>
                </tbody>
              </table>